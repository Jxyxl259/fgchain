package com.fgchain.main;

import com.alibaba.fastjson.JSON;
import com.fgchain.main.module.front.login.dao.UserMapper;
import com.fgchain.main.module.front.login.entity.User;
import com.fgchain.main.module.front.login.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@MapperScan({"com.fgchain.main.module.*.dao"})
@SpringBootTest
public class MainApplicationTests {

    @Autowired
    private UserService userservice;

	@Test
	public void contextLoads() {
	}

	@Test
    public void userSqlTest(){
        User user = userservice.getUserByUsername("jiangBUG");
        System.out.println(JSON.toJSONString(user));
    }
}
