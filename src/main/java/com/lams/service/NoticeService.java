package com.lams.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import com.lams.dao.mapper.SUserMapper;
import com.lams.pojo.SUser;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
@Service("noticeService")
public class NoticeService extends BaseService {

	public List<SUser> listAllUser(){
		return sUserMapper.getAllUserList();
	}
	public void sendActivitiMsg( String  userCodes , String varsJson ,String actTaskID) {
//		String sqrbm = "";
//		String sqrdm = "";
//		String sqrxm = "";
//		String sqyy = "";
//		String sqtype = "";
//		String mj = "";
//		SUser user = null;
//		SUser sqrUser = null;
//		String gotoLamsTaskUrl = "http://"+lamsIP +"/LamsIFSS/gotoTask";
//
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String,Object> vars = null;
//		try {
//			String[] userCodeList = StringUtils.split(userCodes,"[,]");
//			vars = mapper.readValue(varsJson, Map.class);
//			sqrxm = (vars.get("sqrxm") == null ? "" : vars.get("sqrxm").toString());
//			sqrdm = (vars.get("sqrdm") == null ? "" : vars.get("sqrdm").toString());
//			sqrbm = (vars.get("sqrbm") == null ? "" : vars.get("sqrbm").toString());
//			sqyy = (vars.get("sqyy") == null ? "" : vars.get("sqyy").toString());
//			sqtype = (vars.get("sqtype") == null ? "" : vars.get("sqtype").toString());
//			mj = (vars.get("mj") == null ? "" : vars.get("mj").toString());
//			sqrUser = sUserMapper.getUserByUsercode(sqrdm);
//			for (String userCode : userCodeList) {
//				user = sUserMapper.getUserByUsercode(userCode);
//				if(user != null && StringUtils.isNotEmpty(user.getEmail())){
//					String content = todoVM;
//					String todoTitle = sendInfoTitle;
//
//					todoTitle = todoTitle.replace("@sqrUsername", sqrxm);
//					todoTitle = todoTitle.replace("@sqtype", sqtype);
//
//					content = content.replace("@sqrGroupName", sqrbm);
//					content = content.replace("@sqrUsername", sqrxm);
//					content = content.replace("@sqyy", sqyy);
//					content = content.replace("@sqtype", sqtype);
//					content = content.replace("@itemMJ", mj);
//					content = content.replace("@sqrMJ", StringUtils.isNotEmpty(sqrUser.getMj()) ? sqrUser.getMj(): "");
//					content = content.replace("@fqrUsername", user.getUsername());
//					content = content.replace("@gotoLamsUrl", gotoLamsTaskUrl);
//					log.info(content);
//					try {
//						sendInfo(todoTitle , gotoLamsTaskUrl,
//								user.getUsername(), user.getEmail() , "false", content,  actTaskID);
//					} catch (Exception e) {
//						log.error(e.getMessage() , e );
//					}
//					// 调用服务发送  邮件 ======
//					//待办的Title和Email的title 相同
//					System.out.println("=====================================");
//					String todoMailContent = todoMailVM;
//					todoMailContent = todoMailContent.replace("@sqrGroupName", sqrbm);
//					todoMailContent = todoMailContent.replace("@sqrUsername", sqrxm);
//					todoMailContent = todoMailContent.replace("@sqyy", sqyy);
//					todoMailContent = todoMailContent.replace("@sqtype", sqtype);
//					todoMailContent = todoMailContent.replace("@itemMJ", mj);
//					todoMailContent = todoMailContent.replace("@sqrMJ", StringUtils.isNotEmpty(sqrUser.getMj()) ? sqrUser.getMj(): "");
//					todoMailContent = todoMailContent.replace("@fqrUsername", user.getUsername());
//					todoMailContent = todoMailContent.replace("@gotoLamsUrl", gotoLamsTaskUrl);
//					System.out.println(todoMailContent);
//					log.error(todoMailContent);
//					mailSender.SendMultiMail(user.getEmail(), todoTitle, todoMailContent, "text/html");
//				}
//			}
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
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
//	}
//
//	public void sendEmailToCuihuan(String borrowStr) {
//		String 	jyrxm = "";
//		String 	jyrdm = "";
//		String 	gname = "";
//		String 	itemmj = "";
//		String 	sqrmj = "";
//		String 	keyword = "";
//		String 	title = "";
//		String 	jyrqTxt = "";
//		String 	yjghsjTxt = "";
//		String 	libmc = "";
//		String todoTitle = "档案到期催还邮件";
//		try {
//			Map<String, Object> borrow = new ObjectMapper().readValue(borrowStr, Map.class);
//			jyrxm = (borrow.get("jyrxm") == null ? "" : borrow.get("jyrxm").toString());
//			jyrdm = (borrow.get("jyrdm") == null ? "" : borrow.get("jyrdm").toString());
//			gname = (borrow.get("gname") == null ? "" : borrow.get("gname").toString());
//			itemmj = (borrow.get("itemmj") == null ? "" : borrow.get("itemmj").toString());
//			sqrmj = (borrow.get("sqrmj") == null ? "" : borrow.get("sqrmj").toString());
//			keyword = (borrow.get("keyword") == null ? "" : borrow.get("keyword").toString());
//			title = (borrow.get("title") == null ? "" : borrow.get("title").toString());
//			jyrqTxt = (borrow.get("jyrqTxt") == null ? "" : borrow.get("jyrqTxt").toString());
//			yjghsjTxt = (borrow.get("yjghsjTxt") == null ? "" : borrow.get("yjghsjTxt").toString());
//			libmc = (borrow.get("libmc") == null ? "" : borrow.get("libmc").toString());
//
//			String content = cuihuanVM;
//
//			content = content.replace("@username", jyrxm);
//			content = content.replace("@jyrq", jyrqTxt);
//			content = content.replace("@dalxname", libmc);
//			content = content.replace("@keyword", keyword);
//			content = content.replace("@title", title);
//			content = content.replace("@yjghsj", yjghsjTxt);
//			content = content.replace("@itemMJ", itemmj);
//			content = content.replace("@sqrMJ", sqrmj);
//			content = content.replace("@gname", gname);
//			System.out.println(content);
//
//			SUser user = sUserMapper.getUserByUsercode(jyrdm);
//			if(user != null && StringUtils.isNotEmpty(user.getEmail())){
//				mailSender.SendMultiMail(user.getEmail(), todoTitle, content, "text/html");
//			}
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
	}

	public void borrowMailreminderWillExpire(String borrowStr) {
//		String 	jyrxm = "";
//		String 	jyrdm = "";
//		String 	gname = "";
//		String 	itemmj = "";
//		String 	sqrmj = "";
//		String 	keyword = "";
//		String 	title = "";
//		String 	jyrqTxt = "";
//		String 	yjghsjTxt = "";
//		String 	libmc = "";
//		String todoTitle = "档案借阅快到期提醒";
//		try {
//			Map<String, Object> borrow = new ObjectMapper().readValue(borrowStr, Map.class);
//			jyrxm = (borrow.get("jyrxm") == null ? "" : borrow.get("jyrxm").toString());
//			jyrdm = (borrow.get("jyrdm") == null ? "" : borrow.get("jyrdm").toString());
//			gname = (borrow.get("gname") == null ? "" : borrow.get("gname").toString());
//			itemmj = (borrow.get("itemmj") == null ? "" : borrow.get("itemmj").toString());
//			sqrmj = (borrow.get("sqrmj") == null ? "" : borrow.get("sqrmj").toString());
//			keyword = (borrow.get("keyword") == null ? "" : borrow.get("keyword").toString());
//			title = (borrow.get("title") == null ? "" : borrow.get("title").toString());
//			jyrqTxt = (borrow.get("jyrqTxt") == null ? "" : borrow.get("jyrqTxt").toString());
//			yjghsjTxt = (borrow.get("yjghsjTxt") == null ? "" : borrow.get("yjghsjTxt").toString());
//			libmc = (borrow.get("libmc") == null ? "" : borrow.get("libmc").toString());
//
//			String content = borrowWillVM;
//
//			content = content.replace("@username", jyrxm);
//			content = content.replace(" @jyrq", jyrqTxt);
//			content = content.replace("@dalxname", libmc);
//			content = content.replace("@keyword", keyword);
//			content = content.replace("@title", title);
//			content = content.replace("@yjghsj", yjghsjTxt);
//			content = content.replace("@itemMJ", itemmj);
//			content = content.replace("@sqrMJ", sqrmj);
//			content = content.replace("@gname", gname);
//
//			System.out.println(content);
//			SUser user = sUserMapper.getUserByUsercode(jyrdm);
//			if(user != null && StringUtils.isNotEmpty(user.getEmail())){
//				mailSender.SendMultiMail(user.getEmail(), todoTitle, content, "text/html");
//			}
//		} catch (Exception e) {
//			log.error(e.getMessage());
//			e.printStackTrace();
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
//	}
//
//	public NoticeService() {
//		try {
//			EncodedResource chRes = new EncodedResource(new ClassPathResource("config/vm/cuihuanMail.vm"), "UTF-8");
//			EncodedResource todoRes = new EncodedResource(new ClassPathResource("config/vm/todo.vm"), "UTF-8");
//			EncodedResource todoMailRes = new EncodedResource(new ClassPathResource("config/vm/todoMail.vm"), "UTF-8");
//			EncodedResource wmRes = new EncodedResource(new ClassPathResource("config/vm/willMaill.vm"), "UTF-8");
//			cuihuanVM = FileCopyUtils.copyToString(chRes.getReader());
//			todoVM = FileCopyUtils.copyToString(todoRes.getReader());
//			todoMailVM = FileCopyUtils.copyToString(todoMailRes.getReader());
//			borrowWillVM = FileCopyUtils.copyToString(wmRes.getReader());
//		} catch (IOException e) {
//			log.error(e.getMessage());
//			System.out.println("系统初始化邮件待办相关错误");
//			System.exit(0);
//		}
	}
	
	public String getCuihuanVM() {
		return cuihuanVM;
	}

	public String getTodoVM() {
		return todoVM;
	}
	public String getTodoMailVM() {
		return todoMailVM;
	}

	public String getBorrowWillVM() {
		return borrowWillVM;
	}
	
	private String cuihuanVM;
	private String todoVM;
	private String todoMailVM;
	private String borrowWillVM;
	
	@Autowired
	private SUserMapper sUserMapper;
	
	private Logger log =  (Logger) LoggerFactory.getLogger(this.getClass());
}
