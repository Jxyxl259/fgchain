package com.fgchain.main.module.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

	private static Logger log = LoggerFactory.getLogger(TestController.class);



	@RequestMapping("/hello")
	@ResponseBody
	public String test(){

		return "test success";
	}


	@RequestMapping("/test/thymeleaf")
	public String test_thymeleaf(Map<String,Object> map){

		map.put("param_1","<h1>value_1</h1>");
		map.put("namelist", Arrays.asList("zhangsan","lisi","wangwu"));
		return "success";
	}

}