package com.fgchain.main.module.front.login.controller;

import com.fgchain.main.common.enums.GlobalMessageEnum;
import com.fgchain.main.common.RequestResult;
import com.fgchain.main.module.front.login.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller

public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);


    @PostMapping("/doLogin")
    @ResponseBody
    public RequestResult<Boolean> login(User u, HttpSession session){

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
            User user = (User)subject.getPrincipals().getPrimaryPrincipal();
            session.setAttribute("user", user);
        } catch (ExcessiveAttemptsException e) {
            result.setSuccess(false);
            result.setT(false);
                result.setMessage(GlobalMessageEnum.EXCESSIVE_LOGIN_TYR.getMessage());
        } catch (UnknownAccountException e) {
            result.setSuccess(false);
            result.setT(false);
            result.setMessage(GlobalMessageEnum.NO_SUCH_ACCOUNT.getMessage());
        } catch (CredentialsException e){
            result.setSuccess(false);
            result.setT(false);
            result.setMessage(GlobalMessageEnum.ERROR_USERNAME_OR_PASSWORD.getMessage());
        } catch (AuthenticationException e){
            result.setSuccess(false);
            result.setT(false);
            result.setMessage(GlobalMessageEnum.AUTHENTICATION_ERROR.getMessage());
        }

        return result;
    }


}