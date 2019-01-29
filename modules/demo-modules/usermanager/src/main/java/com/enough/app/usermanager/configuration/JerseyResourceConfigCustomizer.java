package com.enough.app.usermanager.configuration;

import com.enough.app.usermanager.resources.UserRootResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.jersey.ResourceConfigCustomizer;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: 实现ResourceConfigCustomizer接口注册资源访问类到Jersey
 * @author: lidong
 * @create: 2019/01/22
 */
@Component
public class JerseyResourceConfigCustomizer implements ResourceConfigCustomizer {
    @Override
    public void customize(ResourceConfig config) {
        //手动添加类，不建议自动扫描包，防止打jar出现异常FileNotFound
        //另外需要早Application类中创建ResourceConfig的bean实例
        config.register(UserRootResource.class);
    }
}
