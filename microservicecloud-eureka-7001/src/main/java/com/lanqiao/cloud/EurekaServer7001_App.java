package com.lanqiao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author DeepSleeping
 * @date 2019/6/15 23:33
 * @description
 */
@SpringBootApplication
@EnableEurekaServer// EurekaServer服务器端启动类，接受其它微服务注册进来
public class EurekaServer7001_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_App.class, args);
    }
}
