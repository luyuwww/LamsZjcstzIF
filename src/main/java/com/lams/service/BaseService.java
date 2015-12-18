package com.lams.service;

import java.io.File;
import java.io.Reader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.Vector;

import com.lams.dao.i.JdbcDao;
import com.lams.dao.mapper.SGroupMapper;
import com.lams.dao.mapper.SUserMapper;
import com.lams.pojo.FDTable;
import com.lams.pojo.SGroup;
import com.lams.pojo.SUser;
import com.lams.util.DateUtil;
import org.apache.ibatis.jdbc.RuntimeSqlException;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
	public SUser getUserByLoginID(String userCode){
		return sUserMapper.getUserByUsercode(userCode);
	}
	protected String generateTimeToSQLDate(Object date){
		String datevalue = null;
		TimeZone.setDefault(TimeZone.getTimeZone("ETC/GMT-8"));  //设置时区 中国/北京/香港
		if(date instanceof Date){
			datevalue = DateUtil.getDateTimeFormat().format(date);
		}else if(date instanceof String){
			datevalue = (String)date;
		}
		if(datevalue.indexOf(".")>-1){//防止出现 2056-12-25 00:00:00.0 而无法导入
			datevalue = datevalue.substring(0, datevalue.lastIndexOf("."));
		}
		datevalue = "TO_DATE('"+datevalue+"', 'yyyy-MM-dd HH24:mi:ss')";
		return datevalue;
	}
	
	/**
	 * 得到数据库的时间 如果错误返回new的时间
	 * 
	 */
	protected Date getDBDateTime() throws RuntimeSqlException{
		Date dbDate = null;
		TimeZone.setDefault(TimeZone.getTimeZone("ETC/GMT-8"));  //设置时区 中国/北京/香港
		dbDate = sUserMapper.selectDateTimeForOra();
		return dbDate;
	}	
	
	
	/**
	 * 根据表名判断数据表是否存在
	 */
	protected Boolean existTable(String tablename){
		boolean result = false;
		Connection conn = null;
		DatabaseMetaData dbmd = null;
		ResultSet rs = null;
		try {
			conn = jdbcDao.getConn();
			dbmd = conn.getMetaData();
			String schemaName = getSchemaName(dbmd);
			rs = dbmd.getTables(null , schemaName ,  tablename, new String[]{"TABLE"});
			if(rs.next()){
				result = true;
			}
		}catch(Exception ex){
			log.error(ex.getMessage());
		}finally{
			try {
				dbmd = null;
				rs.close();
				conn.close();
			} catch (SQLException e) {
				log.error("获取ConnectionMetaData关闭链接错误!");
			}
		}
		return result;
	}
	
	/**
	 * 判断表的字段是否存在
	 */
	protected boolean existColumn(String tablename,String columnName){
		return existColumnOrIndex(tablename, columnName, true);
	}
	/**
	 * 判断字段的索引是否存在
	 */
	protected boolean existIndex(String tablename,String indexName){
		
		return existColumnOrIndex(tablename, indexName, false);
	}
	
	protected Map<String, Object> queryForMap(String sql){
		return jdbcDao.queryForMap(sql);
	}
	
	public Map<String, Object> queryForSingleMap(String sql) {
		List<Map<String, Object>> results = quertListMap(sql);
		if (results.size() == 1) {
			return results.get(0);
		} else if (results.size() > 1) {
			throw new RuntimeSqlException("Query return " + results.size()
					+ " results instead of max 1");
		}
		return null;
	}
	
	protected List<Map<String, Object>> quertListMap(String sql){
		return jdbcDao.quertListMap(sql);
	}
	
	protected String query4String(String sql){
		return jdbcDao.query4String(sql);
	}
	/**
	 * 查新表2列 第一列是key第二列是value的一个map
	 */
	protected Map<String , String> quert2Colum4Map(String sql , String col1 , String col2){
		return jdbcDao.quert2Colum4Map(sql , col1 , col2);
	}
	/**
	 * 判断表的字段或者索引是否存在
	 * @param tablename 表名
	 * @param columnOrIndexName 字段名, 或者索引名
	 * @param isColumn true字段 false索引
	 * @return boolean true存在 false 不存在
	 */
	protected boolean existColumnOrIndex(String tablename,String columnOrIndexName,boolean isColumn){
		boolean result = false;
		Connection conn = null;
		DatabaseMetaData dbmd = null;
		ResultSet rs = null;
		try {
			conn = jdbcDao.getConn();
			dbmd = conn.getMetaData();
			String schemaName = getSchemaName(dbmd);
			if(isColumn){
				rs = dbmd.getColumns(null, schemaName, tablename, columnOrIndexName);
				if(rs.next()){
					result = true;
				}
			}else{
				rs = dbmd.getIndexInfo(null, schemaName, tablename, false, false);
				while (rs.next()) {
					String indexName = rs.getString(6);
					if(indexName!=null&&indexName.equals(columnOrIndexName)){
						result = true;
						break;
					}
				}
			}
		}catch(Exception ex){
			log.error(ex.getMessage());
		}finally{
			try {
				dbmd = null;
				rs.close();
				conn.close();
			} catch (SQLException e) {
				log.error("获取ConnectionMetaData关闭链接错误!");
			}
		}
		return result;
	}
	
	/**
	 * 根据表字段是否可以为空
	 */
	protected boolean validateColumnIsNULL(String tablename,String columnName){
		boolean result = false;
		Connection conn = null;
		DatabaseMetaData dbmd = null;
		ResultSet rs = null;
		try {
			conn = jdbcDao.getConn();
			dbmd = conn.getMetaData();
			String schemaName = getSchemaName(dbmd); 
			rs = dbmd.getColumns(null, schemaName , tablename, columnName);
			if(rs.next()){
				String notnull = rs.getString(11);
				result = notnull!=null&&notnull.equals("1");
			}
		}catch(Exception ex){
			log.error(ex.getMessage());
		}finally{
			try {
				dbmd = null;
				rs.close();
				conn.close();
			} catch (SQLException e) {
				log.error("获取ConnectionMetaData关闭链接错误!");
			}
		}
		return result;
	}
	
	/**
	 * 执行sql文件
	 */
	protected boolean runScript(Reader reader){
		boolean result = false;
		Connection conn = null;
		try {
			conn = jdbcDao.getConn();
			ScriptRunner runner = new ScriptRunner(conn);  
			runner.setErrorLogWriter(null);  
			runner.setLogWriter(null);  
			runner.runScript(reader);  
			result = true;
		}catch(Exception ex){
			log.error(ex.getMessage() + "执行sql文件错误" , ex);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				log.error(e.getMessage() + "获取ConnectionMetaData关闭链接错误!" , e);
			}
		}
		return result;
	}
	
	/**
	 * 获取表模式 private
	 */
	private String getSchemaName(DatabaseMetaData dbmd) throws SQLException{
		return dbmd.getUserName();
	}
	
	protected void execSql(String sql){
		try {
			jdbcDao.excute(sql);
		} catch (Exception e) {
			log.error(e.getMessage() , e);
		}
	}
	/**
	 * 通过groupdid得到bmid
	 * @author: LuYu
	 */
	protected String getBmidByDepCode(String depCode){
		StringBuffer bmid = new StringBuffer();
		SGroup firstGroup = this.getGroupByDepId(depCode);
		try {
			List<SGroup> groupList = this.getGroupList(firstGroup.getDid() , null);
			bmid.append(groupList.get(0).getQzh());
			Collections.reverse(groupList);
			for (SGroup group : groupList) {
				bmid.append("_").append(group.getDid());
			}
		} catch (Exception e) {
			bmid.append("");
			log.error("getUserByUserCode类在通过groupDID得到group的时候的时错误,在 getGroupByDid is " + e.getMessage());
		}
		return bmid.toString();
	}
	/**
	 * 通过usercode得到bmid
	 * @author: LuYu
	 */
	protected String getBmidByuserCode(String usercode){
		StringBuffer bmid = new StringBuffer();
		try {
			Integer groupDid = sUserMapper.getUserByUsercode(usercode).getPid();
			if(groupDid == null){
				return null;
			}
			List<SGroup> groupList = this.getGroupList(groupDid , null);
			bmid.append(groupList.get(0).getQzh());
			Collections.reverse(groupList);
			for (SGroup group : groupList) {
				bmid.append("_").append(group.getDid());
			}
		} catch (Exception e) {
			bmid.append("");
			log.error("getUserByUserCode类在通过groupDID得到group的时候的时错误,在 getGroupByDid is " + e.getMessage());
		}
		return bmid.toString();
	}

	/**
	 * 获取数据库参数 数据库类型名称,时间
	 */
	protected String getSysdate(){
		if(sysdate!=null){
			return sysdate;
		}
		sysdate = "SYSDATE";
		return sysdate;
	}
	
	protected SGroup getGroupByDid(Integer did){
		return sGroupMapper.selectByPrimaryKey(did);
	}
	protected SGroup getGroupByDepId(String depId){
		return sGroupMapper.getGroupByDepID(depId);
	}
	
	protected SUser getUserByUserCode(String usercode){
		return sUserMapper.getUserByUsercode(usercode);
	}
	
	/**
	 * 通过组的得到一个groupList 从小到大 从最底层到最高层
	 */
	private List<SGroup> getGroupList(Integer groupDid , List<SGroup> groupList){
		SGroup tempGroup = this.getGroupByDid(groupDid);
		if(groupList == null){
			groupList = new ArrayList<SGroup>();
		}
		groupList.add(tempGroup);
		if(tempGroup.getPid() != 0){
			this.getGroupList(tempGroup.getPid(), groupList);
		}
		return groupList;
		
	}
	
	protected Integer getMaxDid(String tableName){
		Integer returnMaxDid = sUserMapper.getMaxDid(tableName);
		if(returnMaxDid == null ){
			returnMaxDid = 1;
		}else{
			returnMaxDid = returnMaxDid + 1;
		}
		return returnMaxDid;
		
	}

	
	@Autowired
	protected JdbcDao jdbcDao;
	@Autowired
	protected SGroupMapper sGroupMapper;
	@Autowired
	protected SUserMapper sUserMapper;

	private String sysdate = null;
	private List<FDTable> logList = null;//部门f表的字段list
	protected String sortSeparator = File.separator ;
	private Logger log =  (Logger) LoggerFactory.getLogger(this.getClass());
}
