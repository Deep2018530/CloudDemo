package com.lanqiao.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DeepSleeping
 * @date 2019/6/22 10:41
 * @description
 */
@Configuration
public class MySlefRule {

    @Bean
    public IRule myRule() {
        //自定义负载均衡策略，每台机器5次后再轮询下一个
        return new RandomRule_deepz();
    }
}
