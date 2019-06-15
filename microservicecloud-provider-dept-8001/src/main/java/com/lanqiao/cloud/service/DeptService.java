package com.lanqiao.cloud.service;

import com.lanqiao.springcloud.entity.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptService {
    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
