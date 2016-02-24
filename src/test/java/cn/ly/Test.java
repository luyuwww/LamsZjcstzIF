package cn.ly;

import com.lams.WarApplication;
import com.lams.pojo.SUser;
import com.lams.service.BaseService;
import com.lams.service.NoticeService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by DaMo on 2016/1/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WarApplication.class)
public class Test {
    @org.junit.Test
    public void test001() {
        List<SUser> userList = noticeService.listAllUser();
        for (SUser sUser : userList) {
            System.out.println(sUser.getUsername());
        }
    }

    @Autowired
    private BaseService baseService;
    @Autowired
    private NoticeService noticeService;
}
