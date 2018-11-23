package com.fgchain.main.module.front.login.service.impl;

import com.alibaba.fastjson.JSON;
import com.fgchain.main.common.Pair;
import com.fgchain.main.module.background.zone.system.dto.MenuDto;
import com.fgchain.main.module.background.zone.system.entity.Menu;
import com.fgchain.main.module.front.login.dao.UserMapper;
import com.fgchain.main.module.front.login.entity.User;
import com.fgchain.main.module.front.login.service.UserService;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

import static com.fgchain.main.common.Constants.MENU_LV_1;
import static com.fgchain.main.common.Constants.MENU_LV_2;
import static com.fgchain.main.common.Constants.ROOT_MENU;

/**
 * @description:
 * @author:
 * @create: 2018-07-08 14:34
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        log.debug("getUserByUserName param username={}", username);
        User user = userMapper.selectByUsername(username);
        log.debug("getUserByUserName result userEntity={}", JSON.toJSONString(user));
        return user;

    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        log.debug("getUserByUsernameAndPassword param username={}, psssword={}", username, password);
        User user = userMapper.selectByUsernameAndPassword(username, password);
        log.debug("getUserByUsernameAndPassword result userEntity={}", JSON.toJSONString(user));
        return user;
    }

    @Override
    public User getUserInfoByUserId(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }



    @Override
    public MenuDto getMenuPermsOfUser(Long userId) {

        // 先通过用户Id查询出所属该用户的所有menu权限
        List<Menu> menus = userMapper.selectMenuPermsByUserId(userId);

        Map<Integer, Pair<Menu, List<MenuDto>>> menuMaker = new HashMap<>();

        MenuDto rootMenu = new MenuDto(1,0,ROOT_MENU,0,0,0,null,null);

        menus.forEach(m -> {

            MenuDto menuDto = new MenuDto(m);

            if(MENU_LV_1.equals(m.getMenuLevel())){

                Pair<Menu, List<MenuDto>> menu_level_1 = menuMaker.get(m.getMenuId());

                if(menu_level_1 == null){

                    List<MenuDto> menu_level_1_childs = new ArrayList<>();

                    Pair<Menu, List<MenuDto>> menuMapping = new Pair<>(m, menu_level_1_childs);

                    menuMaker.put(m.getMenuId(), menuMapping);

                }else{

                    String menuName = menu_level_1.getK().getMenuName();

                    if(StringUtils.isEmpty(menuName)){

                        menu_level_1.setK(m);

                    }

                }

                rootMenu.getChildMenu().add(menuDto);

            }else{

                Pair<Menu, List<MenuDto>> menuListPair = menuMaker.get(m.getMenuParentId());

                if(menuListPair == null){

                    ArrayList<MenuDto> level_2_menus = new ArrayList<>(2);

                    level_2_menus.add(menuDto);

                    menuMaker.put(m.getPermId(), new Pair<>(new Menu(), level_2_menus));

                }else{

                    menuListPair.getV().add(menuDto);

                }

            }

        });

        rootMenu.getChildMenu().forEach(menu_level_1 -> {

            List<MenuDto> v = menuMaker.get(menu_level_1.getMenuId()).getV();

        });


//        Map<Integer, Menu> lv_1_menus = new HashMap<>();
//
//        Map<Integer, Menu> lv_2_menus = new HashMap<>();
//
//        menus.forEach(menu -> {
//            if(MENU_LV_1.equals(menu.getMenuLevel())){
//                lv_1_menus.put(menu.getMenuParentId(), menu);
//            }
//            if(MENU_LV_2.equals(menu.getMenuLevel())){
//                lv_2_menus.put(menu.getMenuParentId(), menu);
//            }
//        });
//
//        MenuDto menuDto = new MenuDto(1,0,ROOT_MENU,0,0,0,null,null);
//
//        lv_1_menus.values().forEach( m1 -> {
//            Menu menu = lv_2_menus.get(m1.getMenuId());
//        });

        return null;
    }
}
