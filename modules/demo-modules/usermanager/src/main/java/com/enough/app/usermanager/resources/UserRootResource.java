package com.enough.app.usermanager.resources;

import com.enough.app.usermanager.commontypes.UserInfo;
import com.enough.app.usermanager.services.UserInfoService;
import com.enough.host.server.spring.boot.starter.autoconfigure.HostServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: lidong
 * @create: 2019/01/22
 */
@Component
@Path("/userroot/users")
public class UserRootResource {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private HostServerProperties hostserver;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List <UserInfo> getAllUserInfos(){
        return userInfoService.getAllUserInfos();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public boolean addUser(UserInfo userInfo){
        return userInfoService.addUserInfo(userInfo);
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public UserInfo queryUserInfo(@PathParam("id") String id){
        UserInfo user = userInfoService.queruUserInfoById(id);
        return user;
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public boolean deleteUserInfo(@QueryParam("id") String id){
        return userInfoService.delectUserInfo(id);
    }

    @GET
    @Path("/test")
    @Produces({MediaType.APPLICATION_JSON})
    public Map <String,Object> test(){
        Map<String,Object> hashMap = new HashMap <>();
        hashMap.put("hostserver",hostserver);
        hashMap.put("javaPath",System.getProperty("java.library.path").split(";"));
        return hashMap;
    }
}
