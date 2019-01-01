package com.fgchain.main;

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
    protected UserService userservice;

	@Test
	public void contextLoads() {
	}


}
