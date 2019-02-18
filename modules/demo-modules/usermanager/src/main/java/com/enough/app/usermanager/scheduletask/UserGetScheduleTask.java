package com.enough.app.usermanager.scheduletask;

import com.enough.app.usermanager.commontypes.UserInfo;
import com.enough.app.usermanager.services.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: demo-app-parent
 * @description: 定时获取所有用户并输出到控制台
 * @author: lidong
 * @create: 2019/02/15
 */
@Component
public class UserGetScheduleTask {

    private static Logger logger = LoggerFactory.getLogger(UserGetScheduleTask.class);

    @Autowired
    private UserInfoService userInfoService;

    @Scheduled(cron = "1 59 14 ? * *")  //每天14点59分1秒（秒 分 时 日 星期 月 年(可留空)，? -- 表示：每）
    private void getAllUsers(){
        List <UserInfo>  users = userInfoService.getAllUserInfos();
        for (UserInfo info : users) {
            logger.info(info.toString());
        }
    }
}
