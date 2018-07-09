//package com.fgchain.main.config.mybatis;
//
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
//import javax.sql.DataSource;
//
///**
// * @description: MybatisConfig
// * @author:
// * @create: 2018-07-08 17:45
// */
//@Configuration
//public class MyBatisConfig {
//
//
//
//
//    @Bean
//    @ConditionalOnClass(DataSource.class)
//    public SqlSessionFactoryBean sqlSessionFactoryBean(){
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//
//        Resource[] resources = new Resource[]{
//          new ClassPathResource("classpath:/com/fgchain/main/module/**/dao/*Mapper.xml")
//        };
//
//        sqlSessionFactoryBean.setMapperLocations(resources);
//
//        return sqlSessionFactoryBean;
//    }
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("com.fgchain.main.module.**.dao");
//        return mapperScannerConfigurer;
//    }
//
//}
