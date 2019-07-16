package com.lanqiao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author DeepSleeping
 * @date 2019/6/14 18:01
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.lanqiao.cloud"})
public class DeptConsumer9001_Feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer9001_Feign_App.class, args);
    }
}
