package com.fgchain.main.module.background.zone.system.controller;

import com.alibaba.fastjson.JSON;
import com.fgchain.main.common.BaseDto;
import com.fgchain.main.common.PageResult;
import com.fgchain.main.common.RequestResult;
import com.fgchain.main.common.RequestResultFactory;
import com.fgchain.main.module.background.zone.system.entity.Role;
import com.fgchain.main.module.background.zone.system.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.fgchain.main.common.GlobalMessageEnum.EMPTY_DATA;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @ClassName RoleController
 * @Description
 * @Author jiangxy
 * @Date 2018\11\19 0019 16:36
 * @Version 1.0.0
 */
@Controller
public class RoleController {

    private Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;


    @RequestMapping(value="/zone/sys/role/list", method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public RequestResult<PageResult<Role>> getUserList(@RequestBody BaseDto pagenationInfo){
        RequestResult<PageResult<Role>> result = null;
        Page<Role> page = PageHelper.startPage(1, Integer.MAX_VALUE);
        List<Role> list = roleService.getList();
        if(!CollectionUtils.isEmpty(list)){
            PageResult<Role> pageData = new PageResult<>(page);
            result = RequestResultFactory.success(pageData);
        }else{
            result = RequestResultFactory.failed(EMPTY_DATA);
        }
        log.info("getList result:{}",  JSON.toJSONString(result));
        return result;
    }


}
