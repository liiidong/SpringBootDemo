package com.enough.host.server.spring.boot.starter.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: host-server-spring-boot-starter
 * @description:
 * @author: lidong
 * @create: 2019/01/24
 */

//定义为配置类
@Configuration
//在web条件下成立
@ConditionalOnWebApplication
//启用HostServerProperties配置功能，并加入到IOC容器中
@EnableConfigurationProperties({HostServerProperties.class})
//@ConditionalOnClass(HostServerInfo.class) // 需要被配置的类
@ConditionalOnProperty(prefix = "hostserver", value = "enable", matchIfMissing = true)
public class HostServerAutoConfiguration {

    //    @Autowired
    //    private HostServerProperties hostServerProperties;
    //
    //    /**
    //     * 给bean注入参数，同时返回一个bean实例
    //     * 同时注解表名，返回是一个bean实例
    //     * 当容器中没有这个bean实例的时候，就返回一个自动注入好参数的bean实例回去
    //     *
    //     * @return HelloService
    //     */
    //    @Bean
    //    @ConditionalOnMissingBean(HostServerInfo.class)
    //    public HostServerInfo hostServerProperties() {
    //        HostServerInfo hostServer = new HostServerInfo();
    //        hostServer.setUsername(hostServerProperties.getUsername());
    //        hostServer.setPassword(hostServerProperties.getPassword());
    //        return hostServer;
    //    }
}
