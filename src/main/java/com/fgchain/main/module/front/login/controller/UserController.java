package com.fgchain.main.module.front.login.controller;

import com.alibaba.fastjson.JSON;
import com.fgchain.main.module.common.RequestResult;
import com.fgchain.main.module.common.RequestResultFactory;
import com.fgchain.main.module.front.login.entity.User;
import com.fgchain.main.module.front.login.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 用户相关的控制器
 * @author: jiangxy
 * @create: 2018-07-10 23:20
 */
@Controller
@RequestMapping("/user")
public class UserController {

    public static Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @PostMapping("/userHeaderIcon/{username}")
    @ResponseBody
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


}
