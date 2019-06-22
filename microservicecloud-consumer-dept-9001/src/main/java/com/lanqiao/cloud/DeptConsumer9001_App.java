package com.lanqiao.cloud;

import com.lanqiao.myrule.MySlefRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import javax.security.auth.login.Configuration;

/**
 * @author DeepSleeping
 * @date 2019/6/14 18:01
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySlefRule.class)
public class DeptConsumer9001_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer9001_App.class, args);
    }
}
