package com.fgchain.main.module.background.zone.system.controller;

import com.alibaba.fastjson.JSON;
import com.fgchain.main.common.PageResult;
import com.fgchain.main.common.RequestResult;
import com.fgchain.main.common.RequestResultFactory;
import com.fgchain.main.module.background.zone.system.dto.MenuDto;
import com.fgchain.main.module.background.zone.system.dto.UserDto;
import com.fgchain.main.module.background.zone.system.entity.Menu;
import com.fgchain.main.module.background.zone.system.service.AccountService;
import com.fgchain.main.module.background.zone.system.service.PermService;
import com.fgchain.main.module.background.zone.system.service.RoleService;
import com.fgchain.main.module.front.login.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Iterables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fgchain.main.common.Constants.*;
import static com.fgchain.main.common.enums.GlobalMessageEnum.EMPTY_DATA;

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
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermService permService;

    @RequestMapping(value = "/zone/sys/user/list", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RequestResult<PageResult<User>> getUserList(@RequestBody UserDto userDto){
    //public String getUserList(@RequestBody UserDto userDto){
        RequestResult<PageResult<User>> result = null;
        log.info("getList userDto_param:{}", JSON.toJSONString(userDto));
        Page<User> page = PageHelper.startPage(userDto.getPageNum(), userDto.getPageSize());
        List<User> list = accountService.getList(userDto);
        if(!CollectionUtils.isEmpty(list)){
            PageResult<User> pageData = new PageResult<>(page);
            result = RequestResultFactory.success(pageData);
        }else{
            result = RequestResultFactory.failed(EMPTY_DATA);
        }
        log.info("getList result:{}",  JSON.toJSONString(result));
        return result;
    }

    /**
     * 根据角色Id 获取该角色所拥有的所有权限（菜单权限/按钮权限）
     * @param roleId
     * @return
     */
    @RequestMapping("/zone/sys/user/getPermByRoleId")
    @ResponseBody
    public RequestResult<Map<String, Object>> getRolePermByRoleId(Integer roleId){
        log.info("getPermByRoleId, roleId={}", roleId);
        RequestResult result = RequestResultFactory.success();
        List<Menu> allMenus = permService.allMenus();

        // 通过角色Id查询出该角色所拥有的全部菜单权限
        List<Menu> roleMenuPerms = roleService.getMenuPermsByRoleId(roleId);

        // 通过角色Id查询出该角色所拥有的全部按钮权限
        //List<ButtonPerm> buttonPerms = roleService.getButtonPermsByRoleId(roleId);


        // 菜单权限 组成菜单模型
        // 根菜单
        MenuDto menuDto = new MenuDto(1,0,ROOT_MENU,0,0,0,null,null);

        Iterables.removeIf(roleMenuPerms, m1 -> {
            if(MENU_LV_1.equals(m1.getMenuLevel())){
                MenuDto menu_lv_1 = new MenuDto();
                BeanUtils.copyProperties(m1, menu_lv_1);
                menuDto.getChildMenu().add(menu_lv_1);

                Iterables.removeIf(roleMenuPerms, m2 -> {
                    if(MENU_LV_2.equals(m2.getMenuLevel()) && m1.getMenuId().equals(m2.getMenuParentId())){
                        MenuDto menu_lv_2 = new MenuDto();
                        BeanUtils.copyProperties(m2, menu_lv_2);
                        menu_lv_1.getChildMenu().add(menu_lv_2);
                        return true;
                    }
                    return false;
                });
            }
            return true;
        });

        log.info("该角色所拥有的所有菜单权限：{}", JSON.toJSONString(menuDto));
        // 按钮权限，set集合

        Map<String, Object> permsOfRole = new HashMap<>();
        permsOfRole.put("menus", menuDto);
        //permsOfRole.put("buttons", menuDto);
        result.setT(permsOfRole);
        return  result;
    }


}
