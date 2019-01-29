package com.enough.app.usermanager.commontypes;

/**
 * @program: demo
 * @description:
 * @author: lidong
 * @create: 2019/01/21
 */
public class UserInfo {

    public UserInfo(){}

    public UserInfo(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String id;
    public String name;
    public String password;
    public String role;

//    @Override
//    public String toString() {
//        return "UserInfo{" + "name='" + name + '\'' + ", password='" + password + '\'' + ", role='" + role + '\'' + '}';
//    }
}
