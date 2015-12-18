package com.lams.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lams.dao.mapper.SUserMapper;
import com.lams.pojo.SUser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import org.springframework.util.FileCopyUtils;

@Service("noticeService")
public class NoticeService extends BaseService {

	public List<SUser> listAllUser(){
		return sUserMapper.getAllUserList();
	}
	public void sendActivitiMsg( String  userCodes , String varsJson ,String actTaskID) {
		String sqrbm = "";
		String sqrdm = "";
		String sqrxm = "";
		String sqyy = "";
		String sqtype = "";
		String mj = "";
		SUser user = null;
		SUser sqrUser = null;
		String gotoLamsTaskUrl = "http://"+lamsIP +"/LamsIFSS/gotoTask";

		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> vars = null;
		try {
			String[] userCodeList = StringUtils.split(userCodes,"[,]");
			vars = mapper.readValue(varsJson, Map.class);
			sqrxm = (vars.get("sqrxm") == null ? "" : vars.get("sqrxm").toString());
			sqrdm = (vars.get("sqrdm") == null ? "" : vars.get("sqrdm").toString());
			sqrbm = (vars.get("sqrbm") == null ? "" : vars.get("sqrbm").toString());
			sqyy = (vars.get("sqyy") == null ? "" : vars.get("sqyy").toString());
			sqtype = (vars.get("sqtype") == null ? "" : vars.get("sqtype").toString());
			mj = (vars.get("mj") == null ? "" : vars.get("mj").toString());
			sqrUser = sUserMapper.getUserByUsercode(sqrdm);
			for (String userCode : userCodeList) {
				user = sUserMapper.getUserByUsercode(userCode);
				if(user != null && StringUtils.isNotEmpty(user.getEmail())){
					String content = todoVM;
					String todoTitle = sendInfoTitle;

					todoTitle = todoTitle.replace("@sqrUsername", sqrxm);
					todoTitle = todoTitle.replace("@sqtype", sqtype);

					content = content.replace("@sqrGroupName", sqrbm);
					content = content.replace("@sqrUsername", sqrxm);
					content = content.replace("@sqyy", sqyy);
					content = content.replace("@sqtype", sqtype);
					content = content.replace("@itemMJ", mj);
					content = content.replace("@sqrMJ", StringUtils.isNotEmpty(sqrUser.getMj()) ? sqrUser.getMj(): "");
					content = content.replace("@fqrUsername", user.getUsername());
					content = content.replace("@gotoLamsUrl", gotoLamsTaskUrl);
					log.info(content);
					try {
						sendInfo(todoTitle , gotoLamsTaskUrl,
								user.getUsername(), user.getEmail() , "false", content,  actTaskID);
					} catch (Exception e) {
						log.error(e.getMessage() , e );
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	public void sendDestoryMsg(String operUserCode, String actTaskId) {
//		SUser user = null;
//		try {
//			user = sUserMapper.getUserByUsercode(operUserCode);
//			System.out.println("keys: " +  actTaskId + "-" +operUserCode);
//			sendInfo("" , "" ,	user.getUsername(), user.getEmail() , "true", "",  actTaskId);
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
	}

	/**
	 * 向OA发送待办
	 * @param title
	 * @param url
	 * @param isProcessed
	 * @param summery
	 * @param taskid
	 */
	public void sendInfo(String title , String url , String receiveUserName
					, String receiveUserMail , String isProcessed , String summery , String taskid){
//		try {
//			String dateStr = DateUtil.getCurrentTimeStr();
//			WebServiceSoap webServiceSoap = new WebService(new URL(sendInfoWsdl),
//					new QName("http://tempuri.org/", "WebService")).getWebServiceSoap();
//			webServiceSoap.sendInfo(title , url , dateStr , sendInfoSource , receiveUserName
//					, receiveUserMail , isProcessed , summery , taskid);
////			webServiceSoap.sendInfo(title , url , dateStr , "Lams" , receiveUserName,
////					receiveUserMail, isProcessed, summery,	taskid);
//
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
	}

	public NoticeService() {
		try {
			EncodedResource todoRes = new EncodedResource(new ClassPathResource("vm/todo.vm"), "UTF-8");
			todoVM = FileCopyUtils.copyToString(todoRes.getReader());
		} catch (IOException e) {
			log.error(e.getMessage());
			System.out.println("系统初始化邮件待办相关错误");
			System.exit(0);
		}
	}
	
	public String getTodoVM() {
		return todoVM;
	}

	private String todoVM;

	@Value("${sendinfo.todo.title}")
	private String sendInfoTitle;//发送info的title

	@Autowired
	private SUserMapper sUserMapper;
	
	private Logger log =  (Logger) LoggerFactory.getLogger(this.getClass());
}
