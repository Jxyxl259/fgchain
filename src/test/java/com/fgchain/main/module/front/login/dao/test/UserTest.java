package com.fgchain.main.module.front.login.dao.test;

import com.alibaba.fastjson.JSON;
import com.fgchain.main.MainApplicationTests;
import com.fgchain.main.module.front.login.entity.User;
import org.junit.Test;

/**
 * @description: 用户表相关sql测试类
 * @author: jiangxy
 * @create: 2018-07-10 21:48
 */
public class UserTest extends MainApplicationTests {

    @Test
    public void userSqlTest(){
        User user = userservice.getUserByUsername("jiangBUG");
        System.out.println(JSON.toJSONString(user));
    }

}
