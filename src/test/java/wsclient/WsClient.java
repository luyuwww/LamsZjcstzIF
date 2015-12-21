package wsclient;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import stub.*;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by DaMo on 2015/12/21.
 */
public class WsClient {
    @Test
    public void testInsertWork(){
        ExpectedApproval expectedApproval = new ExpectedApproval();
        ExpectedApprovalSoap stub = expectedApproval.getExpectedApprovalSoap();
//        stub.insertWork()
        WaitWork ww = new ObjectFactory().createWaitWork();
        ww.setWaitID("flowid 23020302-23023-23023");
        ww.setWorkName("title");
        ww.setAccountName("处理人账号（必填，对应办理人，这个地方不加密）");
        ww.setWaitURL("http://www.baidu.com");
        ww.setFlowType("0");
        ww.setCreatorName("个人理解这是发起人");
//        ww.setCreateDate();//创建时间必须填写
        ww.setSystemNo("dangaxitong");//配置文件配置
        NotifyTodoAppResult result = stub.insertWork(ww);
        result.getMessage();
    }

    @Test
    public void testDelWork(){
        ExpectedApproval expectedApproval = new ExpectedApproval();
        ExpectedApprovalSoap stub = expectedApproval.getExpectedApprovalSoap();
        NotifyTodoAppResult result = stub.deleteWork("flowid 23020302-23023-23023");
        result.getMessage();
    }
}
