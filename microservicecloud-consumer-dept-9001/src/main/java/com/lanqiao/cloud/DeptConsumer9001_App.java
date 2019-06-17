package com.lanqiao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author DeepSleeping
 * @date 2019/6/14 18:01
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer9001_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer9001_App.class, args);
    }
}
