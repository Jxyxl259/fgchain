package com.fgchain.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

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

}