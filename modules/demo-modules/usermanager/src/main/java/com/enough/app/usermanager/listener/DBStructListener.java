package com.enough.app.usermanager.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @program: demo-app-parent
 * @description:
 * @author: lidong
 * @create: 2019/02/15
 */
@Component
public class DBStructListener implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(ApplicationReadyEventListener.class);
    public DBStructListener(){

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("数据库操作监听");
        //System.out.println("数据库操作监听");
    }
}
