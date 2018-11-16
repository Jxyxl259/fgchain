package com.fgchain.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "com.fgchain.main.module",
        "com.fgchain.main.config"
})
@MapperScan({
        "com.fgchain.main.module.**.dao"
})
public class MainApplication {
	// 测试jenkins构建15
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
