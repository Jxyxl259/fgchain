package com.fgchain.main.config.ehcache;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @description: ehcache配置类
 * @author:
 * @create: 2018-07-08 15:11
 */
@Configuration
public class EhcacheConfig {

    @Bean
    public CacheManager ehCacheManager(){
        EhCacheManagerFactoryBean ehCacheManagerFactory = new EhCacheManagerFactoryBean();
        ehCacheManagerFactory.setConfigLocation(new ClassPathResource("EhcacheConfig/ehcache.xml"));
        ehCacheManagerFactory.afterPropertiesSet();
        return ehCacheManagerFactory.getObject();
    }

}
