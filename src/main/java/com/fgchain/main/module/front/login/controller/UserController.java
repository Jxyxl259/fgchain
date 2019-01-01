package com.fgchain.main.module.front.login.controller;

import com.alibaba.fastjson.JSON;
import com.fgchain.main.common.RequestResult;
import com.fgchain.main.common.RequestResultFactory;
import com.fgchain.main.module.background.zone.system.dto.MenuDto;
import com.fgchain.main.module.background.zone.system.entity.Menu;
import com.fgchain.main.module.front.login.entity.User;
import com.fgchain.main.module.front.login.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 用户相关的控制器
 * @author: jiangxy
 * @create: 2018-07-10 23:20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    public static Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @PostMapping("/userHeaderIcon/{username}")
    public RequestResult<User> getUserDetail(@PathVariable("username") String username){
        log.debug("getUserDetail param={}", username);

        User user = userService.getUserByUsername(username);

        log.debug(user == null ? "no such user named " + username  + "!" : "getUserDetail result={" + JSON.toJSONString(user) + "}");

        if(user != null){
            return RequestResultFactory.success(user);
        }else{
            return new RequestResult<User>(false);
        }
    }

    @PostMapping("/fetchUserPerms")
    public RequestResult getUserPerms(HttpServletRequest request){
        User u = (User)request.getSession().getAttribute("user");
        Long userId = u.getUserId();
        MenuDto rootMenu = userService.getMenuPermsOfUser(userId);
        return RequestResultFactory.success(rootMenu);
    }



}
