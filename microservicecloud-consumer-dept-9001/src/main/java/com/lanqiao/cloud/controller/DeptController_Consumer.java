package com.lanqiao.cloud.controller;

import com.lanqiao.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author DeepSleeping
 * @date 2019/6/14 17:42
 * @description 部门服务消费者
 */
@RestController
public class DeptController_Consumer {


    //    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://microservicecloud-dept";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {

        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @GetMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {

        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @GetMapping(value = "/consumer/dept/list")
    public List<Dept> list() {

        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @GetMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "dept/discovery", Object.class);
    }
}
