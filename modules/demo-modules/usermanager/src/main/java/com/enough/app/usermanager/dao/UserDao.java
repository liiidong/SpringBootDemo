package com.enough.app.usermanager.dao;

import com.enough.app.usermanager.commontypes.UserInfo;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: lidong
 * @create: 2019/01/22
 */
public interface UserDao {

    int addUserInfo(UserInfo userInfo);

    List <UserInfo> getAllUserInfos();

    UserInfo queruUserInfoById(String id);

    int delectUserInfo(String id);
}
