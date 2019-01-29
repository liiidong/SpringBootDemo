package com.enough.app.usermanager.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: demo-app-parent
 * @description:
 * @author: lidong
 * @create: 2019/01/23
 */
@Component
public class ApplicationReadyEventListener implements ApplicationListener <ApplicationReadyEvent> {
    private static Logger logger = LoggerFactory.getLogger(ApplicationReadyEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("启动成功");
        logger.debug("启动成功");
    }

}
