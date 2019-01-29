package com.enough.host.server.spring.boot.starter.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: host-server-spring-boot-starter
 * @description:
 * @author: lidong
 * @create: 2019/01/24
 */
@Component
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "hostserver")
public class HostServerProperties {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
