package com.lanqiao.cloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author DeepSleeping
 * @date 2019/6/14 17:36
 * @description
 */
@Configuration
public class ConfigBean {

    /**
     * @description 对Configbean进行注解@LoadBalanced 获得Rest时加入Ribbon的配置
     * @author DeepSleeping
     * @date 2019/6/17 19:44
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        //用我们重新选择的随机算法替代默认的轮询算法
        return new RandomRule();
    }
}
