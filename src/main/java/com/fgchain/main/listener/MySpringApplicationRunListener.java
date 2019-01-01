package com.fgchain.main.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @ClassName MySpringApplicationRunListener
 * @Description
 * @Author jiangxy
 * @Date 2018\9\6 0006 16:39
 * @Version 1.0.0
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {


    public MySpringApplicationRunListener(SpringApplication application, String[] args) {

    }


    @Override
    public void starting() {

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {

    }
}
