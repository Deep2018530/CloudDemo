package com.lanqiao.springcloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author DeepSleeping
 * @date 2019/6/14 15:18
 * @description
 */
@Data
public class Dept implements Serializable {

    private long deptno;
    private String dname;
    private String db_source;


}
