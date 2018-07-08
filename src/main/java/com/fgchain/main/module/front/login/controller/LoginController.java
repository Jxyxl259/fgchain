package com.fgchain.main.module.front.login.controller;

import com.fgchain.main.module.common.RequestResult;
import com.fgchain.main.module.common.RequestResultFactory;
import com.fgchain.main.module.front.login.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("")
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);


    @PostMapping("/doLogin")
    @ResponseBody
    public RequestResult<Boolean> login(User u){
        log.debug("login user={}", u);
        RequestResult<Boolean> result = RequestResultFactory.success();
        result.setT(true);


        return result;
    }


}