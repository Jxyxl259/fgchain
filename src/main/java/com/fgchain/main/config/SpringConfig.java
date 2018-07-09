package com.fgchain.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	/* starter-parent 1.5.9版本中 MessageSource自动配置不生效，需要手动配置一下 */
//	@Bean
//	public ResourceBundleMessageSource messageSource(){
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setUseCodeAsDefaultMessage(true);
//		messageSource.setFallbackToSystemLocale(false);
//		messageSource.setBasenames("messages","i18n/message");
//		messageSource.setDefaultEncoding("UTF-8");
//		messageSource.setCacheSeconds(2);
//		return messageSource;
//
//	}

    @Bean
    @Autowired
    @ConditionalOnBean(net.sf.ehcache.CacheManager.class)
    public EhCacheCacheManager springCacheCacheManager(net.sf.ehcache.CacheManager ehCacheManager){
        EhCacheCacheManager SpringCacheManager = new EhCacheCacheManager(ehCacheManager);
        return SpringCacheManager;
    }


}