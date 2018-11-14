package com.fgchain.main.config.shiro;

import com.fgchain.main.config.SpringCacheManagerWrapper;
import com.fgchain.main.module.front.login.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @description: Shiro权限管理框架配置
 * @author: jiangxy
 * @create: 2018-07-08 14:17
 */
@Configuration
@Order(3)
public class MyShiroConfig{

    @Autowired
    private SecurityManager securityManager;

    /**
     * SpringCachemanagerWrapper作为缓存包装类,
     * 实现了 org.apache.shiro.cache.CacheManager接口
     * @param springCacheCacheManager
     * @return
     */
    @Bean
    @Autowired
    public CacheManager springCacheManagerWrapper(org.springframework.cache.ehcache.EhCacheCacheManager springCacheCacheManager){
        SpringCacheManagerWrapper springCacheWrapper = new SpringCacheManagerWrapper();
        springCacheWrapper.setCacheManager(springCacheCacheManager);
        return springCacheWrapper;
    }


    /**
     * 创建凭证匹配器
     * 密码尝试次数限制为5次,由缓存实现
     * @return
     */
    @Bean
    @Autowired
    public CredentialsMatcher hashedCredentialsMatcher(org.apache.shiro.cache.CacheManager CacheManager){
        RetryLimitHashedCredentialsMatcher credentialsMatcher = new RetryLimitHashedCredentialsMatcher(CacheManager);
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(2);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }


    /**
     * 自定义Realm实现类
     * @return
     */
    @Bean
    @Autowired
    @ConditionalOnBean(UserService.class)
    public Realm myShiroRealm(CredentialsMatcher credentialsMatcher){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(credentialsMatcher);
        myShiroRealm.setCachingEnabled(true);
        myShiroRealm.setAuthenticationCachingEnabled(true);
        myShiroRealm.setAuthorizationCachingEnabled(true);
        myShiroRealm.setAuthenticationCacheName("authenticationCache");
        myShiroRealm.setAuthorizationCacheName("authorizationCache");
        return myShiroRealm;
    }


    /**
     * 会话Cookie模板
     * @return
     */
    @Bean
    public SimpleCookie sessionIdCookie(){
        SimpleCookie simpleCookie = new SimpleCookie("sid");
        simpleCookie.setHttpOnly(true);

        // cookie 过期时间 设置为永不过期
        simpleCookie.setMaxAge(-1);
        return simpleCookie;
    }


    /**
     * 记住我功能 cookie
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie(){
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);

        // cookie 过期时间 设置为30天
        simpleCookie.setMaxAge(2592000);
        return simpleCookie;
    }


    /**
     * rememberMe管理器(为rememberMe COOKIE进行加密)
     * @return
     */
    @Bean
    public CookieRememberMeManager cookieRememberMeManager(){
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCipherKey(org.apache.shiro.codec.Base64.decode("fgchain"));
        rememberMeManager.setCookie(rememberMeCookie());
        return rememberMeManager;
    }


    /**
     * 设置会话管理器
     * @return
     */
    @Bean
    public DefaultWebSessionManager defaultWebSessionManager(){
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        sessionManager.setGlobalSessionTimeout(1800000);
//        sessionManager.setDeleteInvalidSessions(true);
//        sessionManager.setSessionIdCookieEnabled(true);
//        sessionManager.setSessionIdCookieEnabled(true);
//        sessionManager.setSessionIdCookie(sessionIdCookie());
        MyShiroSessionManager sessionManager = new MyShiroSessionManager();
        return sessionManager;
    }


    /**
     * 设置安全管理器
     * @param myShiroRealm
     * @param springCacheManagerWrapper
     * @param defaultWebSessionManager
     * @param cookieRememberMeManager
     * @return
     */
    @Bean
    @Autowired
    public SecurityManager securityManager(Realm myShiroRealm,
                                           org.apache.shiro.cache.CacheManager springCacheManagerWrapper,
                                           SessionManager defaultWebSessionManager,
                                           RememberMeManager cookieRememberMeManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm);
        securityManager.setCacheManager(springCacheManagerWrapper);
        securityManager.setSessionManager(defaultWebSessionManager);
        securityManager.setRememberMeManager(cookieRememberMeManager);
        return securityManager;
    }


//    @Bean
//    public SecurityUtils securityUtils(SecurityManager securityManager){
//        SecurityUtils.setSecurityManager(securityManager);
//        return
//    }


    /**
     * shiro过滤器工厂类
     * @return
     */
    @Bean
    @ConditionalOnBean(SecurityManager.class)
    @Autowired
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        // 创建一个shiro过滤器工厂类
        ShiroFilterFactoryBean shiroFilterFactory = new ShiroFilterFactoryBean();

        // 设置登陆页面,登陆成功页面,未授权页面
        shiroFilterFactory.setLoginUrl("/toLoginPage");
        shiroFilterFactory.setSuccessUrl("/index");
        shiroFilterFactory.setUnauthorizedUrl("/toUnauthorizedPage");

        shiroFilterFactory.setSecurityManager(securityManager);

        return shiroFilterFactory;
    }


    /**
     * Shiro生命周期处理器(注解需要)
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        LifecycleBeanPostProcessor processor = new LifecycleBeanPostProcessor();
        return processor;
    }



}
