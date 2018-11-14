package com.fgchain.main.config.ehcache;

import net.sf.ehcache.CacheManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;

/**
 * @description: ehcache配置类
 * @author:
 * @create: 2018-07-08 15:11
 */
//@Configuration
//@Order(1)
public class EhcacheConfig {

//    @Bean
//    @Order(9998)
//    @ConditionalOnMissingBean(CacheManager.class)
    public CacheManager cacheManager(){
        EhCacheManagerFactoryBean ehCacheManagerFactory = new EhCacheManagerFactoryBean();
        ehCacheManagerFactory.setConfigLocation(new ClassPathResource("EhcacheConfig/ehcache.xml"));
        ehCacheManagerFactory.afterPropertiesSet();
        return ehCacheManagerFactory.getObject();
    }

}
