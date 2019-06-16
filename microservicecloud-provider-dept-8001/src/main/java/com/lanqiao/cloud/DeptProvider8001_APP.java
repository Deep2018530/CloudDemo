package com.lanqiao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author DeepSleeping
 * @date 2019/6/14 17:12
 * @description
 */
@SpringBootApplication
/**
 * 本服务启动后会自动注册进eureka服务中
 */
@EnableEurekaClient
/**
 * 服务发现
 */
@EnableDiscoveryClient
public class DeptProvider8001_APP {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_APP.class, args);
    }
}
