package com.enough.app.usermanager.impl;

import com.enough.app.usermanager.commontypes.UserInfo;
import com.enough.app.usermanager.dao.UserDao;
import com.enough.app.usermanager.services.UserInfoService;
import com.enough.app.usermanager.utils.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: lidong
 * @create: 2019/01/22
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUserInfo(UserInfo newUserInfo) {
        newUserInfo.id = PrimaryKeyUtil.getInstance().GetPrimaryKeyValue();
        return userDao.addUserInfo(newUserInfo) > 0;
    }

    @Override
    public List <UserInfo> getAllUserInfos() {
        return userDao.getAllUserInfos();
    }

    @Override
    public UserInfo queruUserInfoById(String id) {
        return userDao.queruUserInfoById(id);
    }

    @Override
    public boolean delectUserInfo(String id) {
        return userDao.delectUserInfo(id) > 0;
    }
}
