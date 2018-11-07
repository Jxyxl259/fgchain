package com.fgchain.main.listener;

import org.springframework.boot.CommandLineRunner;

/**
 * @ClassName MyCommandLine
 * @Description
 * @Author jiangxy
 * @Date 2018\9\6 0006 17:01
 * @Version 1.0.0
 */
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner...run... " + args);
    }
}
