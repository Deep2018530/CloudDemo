package com.lanqiao.cloud.controller;

import com.lanqiao.springcloud.entity.Dept;
import com.lanqiao.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DeepSleeping
 * @date 2019/6/14 17:42
 * @description 部门服务消费者
 */
@RestController
public class DeptController_Consumer {


    @Autowired
    private DeptClientService service = null;

    @GetMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.service.get(id);
    }

    @GetMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return this.service.list();
    }

    @PostMapping(value = "/consumer/dept/add")
    public Object add(Dept dept) {
        return this.service.add(dept);
    }
}
