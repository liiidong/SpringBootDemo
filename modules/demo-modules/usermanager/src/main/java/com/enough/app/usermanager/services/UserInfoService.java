package com.enough.app.usermanager.services;

import com.enough.app.usermanager.commontypes.UserInfo;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: lidong
 * @create: 2019/01/22
 */
public interface UserInfoService {

    boolean addUserInfo(UserInfo newUserInfo);

    List <UserInfo> getAllUserInfos();

    UserInfo queruUserInfoById(String id);

    boolean delectUserInfo(String id);
}
