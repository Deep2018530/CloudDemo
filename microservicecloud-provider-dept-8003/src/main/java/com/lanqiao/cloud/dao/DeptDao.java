package com.lanqiao.cloud.dao;

import com.lanqiao.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author DeepSleeping
 * @description
 * @date 2019/6/14 16:53
 */
@Mapper
public interface DeptDao {
    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
