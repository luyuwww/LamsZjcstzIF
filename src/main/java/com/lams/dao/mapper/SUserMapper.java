package com.lams.dao.mapper;

import java.util.List;
import java.util.Map;

import com.lams.dao.BaseDao;
import com.lams.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SUserMapper  extends BaseDao{
    int countByExample(SUserExample example);

    int deleteByExample(SUserExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(SUserWithBLOBs record);

    int insertSelective(SUserWithBLOBs record);

    List<SUserWithBLOBs> selectByExampleWithBLOBs(SUserExample example);

    List<SUser> selectByExample(SUserExample example);

    SUserWithBLOBs selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") SUserWithBLOBs record, @Param("example") SUserExample example);

    int updateByExampleWithBLOBs(@Param("record") SUserWithBLOBs record, @Param("example") SUserExample example);

    int updateByExample(@Param("record") SUser record, @Param("example") SUserExample example);

    int updateByPrimaryKeySelective(SUserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SUserWithBLOBs record);

    int updateByPrimaryKey(SUser record);
    
	@Select("SELECT DID,PID,USERCODE,USERNAME FROM S_USER")
    List<SUser> getAllUserList();
	
	@Select("SELECT * FROM S_USER WHERE USERCODE = '${usercode}'")
	SUser getUserByUsercode(@Param("usercode") String usercode);
	
	@Select("SELECT * FROM S_USER WHERE ESBCODE = '${esbcode}'")
	SUserWithBLOBs getUserBlobByEsbCode(@Param("esbcode") String esbcode);
	
	@Select("SELECT * FROM S_USER WHERE USERCODE = '${usercode}'")
	SUserWithBLOBs getUserBlobUsercode(@Param("usercode") String usercode);
	
	@Select("SELECT QZH FROM S_GROUP WHERE DID IN (SELECT PID FROM S_USER WHERE USERCODE LIKE '${usercode}')")
	String getQzhByUserCode(@Param("usercode") String usercode);
	
	@Select("SELECT  * FROM S_FWQPZ WHERE ISDEFAULT=1")
	SFwqpz getDefaultFwqpz();
	
	@Select("select PID, PATHNAME,TITLE,PZM,EFILENAME,EXT,MD5,FILESIZE,CREATETIME,STATUS,ATTR,ATTREX,CREATOR,DID from ${eTableName} where pid = (select min(did) from ${dTableName} where ${whereSql})")
	List<EFile> getDupliEfile(@Param("eTableName") String eTableName, @Param("dTableName") String dTableName, @Param("whereSql") String whereSql);
	
	@Select("SELECT DID FROM S_USER WHERE DID NOT IN (SELECT YHID FROM S_USERROLE) AND USERCODE <> 'ROOT'")
	List<Integer> getNoRoleUserDids();

	List<DFile> listPageDFileByWhere(Map para);
	List<Map<String, Object>> listPageMapQuery(Map para);
	
	@Select("SELECT COUNT(DID) FROM ${dTableName} WHERE ${whereSql}")
	Integer countNumByWhere(@Param("dTableName") String dTableName, @Param("whereSql") String whereSql);

}