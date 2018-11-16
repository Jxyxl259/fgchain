package com.fgchain.main.module.background.zone.system.user.controller;

import com.alibaba.fastjson.JSON;
import com.fgchain.main.common.PageResult;
import com.fgchain.main.module.background.zone.system.user.dto.UserDto;
import com.fgchain.main.module.background.zone.system.user.service.AccountService;
import com.fgchain.main.module.front.login.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.fgchain.main.common.GlobalMessageEnum.EMPTY_DATA;
import static com.fgchain.main.common.GlobalMessageEnum.SUCCESS;

/**
 * @ClassName UserController
 * @Description
 * @Author jiangxy
 * @Date 2018\11\16 0016 14:26
 * @Version 1.0.0
 */
@Controller
public class AccountController {

    private Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/zone/sys/user/list", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public PageResult<User> getUserList(UserDto userDto){
        PageResult<User> result = null;
        log.info("getList userDto_param:{}", JSON.toJSONString(userDto));
        Page<User> page = PageHelper.startPage(userDto.getPageNum(), userDto.getPageSize());
        List<User> list = accountService.getList(userDto);
        if(!CollectionUtils.isEmpty(list)){
            result = new PageResult<User>(true, page, SUCCESS);
        }else{
            result = new PageResult<User>(false, EMPTY_DATA.getStatus_code(), EMPTY_DATA.getMessage());
        }
        return result;
    }

}
