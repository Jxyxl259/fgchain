package com.fgchain.main.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @ClassName MyApplicationRunner
 * @Description
 * @Author jiangxy
 * @Date 2018\9\6 0006 16:59
 * @Version 1.0.0
 */
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner...run ... " );
    }
}
