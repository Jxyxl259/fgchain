package com.fgchain.main.module.background.zone.system.controller;

import com.alibaba.fastjson.JSON;
import com.fgchain.main.common.BaseDto;
import com.fgchain.main.common.PageResult;
import com.fgchain.main.common.RequestResult;
import com.fgchain.main.common.RequestResultFactory;
import com.fgchain.main.module.background.zone.system.entity.Role;
import com.fgchain.main.module.background.zone.system.service.PermService;
import com.fgchain.main.module.background.zone.system.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.fgchain.main.common.enums.GlobalMessageEnum.EMPTY_DATA;
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

    @Autowired
    private PermService permService;


    @RequestMapping(value="/zone/sys/role/list", method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public RequestResult<PageResult<Role>> getRoleList(@RequestBody BaseDto pagenationInfo){

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

    /**
     * 为角色分配权限
     * @param menuIds 菜单权限 Ids
     * @param btnIds 按钮权限 Ids
     * @return
     */
    @RequestMapping("/zone/sys/role/setRolePerms")
    @ResponseBody
    public RequestResult getRolePermByRoleId(Integer roleId, String menuIds, String btnIds){

        RequestResult result = null;

        // 清空角色原有权限，下面进行重新分配
        int affectRows = roleService.deleteOldRolePrems(roleId);

        List<Integer> permIds = new ArrayList<>();

        if(!StringUtils.isEmpty(menuIds)){

            Integer[] menuIdArr = (Integer[]) ConvertUtils.convert(menuIds.split(","), Integer.class);

            // 通过 menuIds 找到所有的 permIds
            permIds = permService.getPermIdsByMenuIds(menuIdArr);

        }

        if(!StringUtils.isEmpty(btnIds)){

            List<Integer> permBtnIds = Arrays.asList((Integer[]) ConvertUtils.convert(menuIds.split(","), Integer.class));

            permIds.addAll(permBtnIds);

        }

        if(CollectionUtils.isEmpty(permIds)){

            return RequestResultFactory.success(affectRows,"清除角色全部权限信息成功");

        }

        int newItem = roleService.allocateRolePerms(roleId, permIds);

        return RequestResultFactory.success(newItem);

    }

}
