package com.fgchain.main.module.front.login.controller;

import com.fgchain.main.module.common.GlobalMessageEnum;
import com.fgchain.main.module.common.RequestResult;
import com.fgchain.main.module.common.RequestResultFactory;
import com.fgchain.main.module.front.login.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        RequestResult<Boolean> result = new RequestResult<>(true,true);

        Subject subject = SecurityUtils.getSubject();

        if(subject.isAuthenticated()){
           return result;
        }

        String username = u.getUserName();
        String password = u.getUserPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
        } catch (ExcessiveAttemptsException e) {
            result.setSuccess(false);
            result.setT(false);
            result.setResultMsg(GlobalMessageEnum.EXCESSIVE_LOGIN_TYR.getCommon());
            return result;
        } catch (UnknownAccountException e) {
            result.setSuccess(false);
            result.setT(false);
            result.setResultMsg(GlobalMessageEnum.NO_SUCH_ACCOUNT.getCommon());
            return result;
        } catch (CredentialsException e){
            result.setSuccess(false);
            result.setT(false);
            result.setResultMsg(GlobalMessageEnum.ERROR_USERNAME_OR_PASSWORD.getCommon());
            return result;
        } catch (AuthenticationException e){
            result.setSuccess(false);
            result.setT(false);
            result.setResultMsg(GlobalMessageEnum.AUTHENTICATION_ERROR.getCommon());
        }

        return result;
    }


}