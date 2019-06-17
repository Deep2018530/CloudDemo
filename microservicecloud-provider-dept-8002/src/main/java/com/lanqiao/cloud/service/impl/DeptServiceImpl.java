package com.lanqiao.cloud.service.impl;

import com.lanqiao.cloud.dao.DeptDao;
import com.lanqiao.cloud.service.DeptService;
import com.lanqiao.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DeepSleeping
 * @date 2019/6/14 17:02
 * @description
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao;

    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    public Dept get(Long id) {
        return dao.findById(id);
    }

    public List<Dept> list() {
        return dao.findAll();
    }
}
