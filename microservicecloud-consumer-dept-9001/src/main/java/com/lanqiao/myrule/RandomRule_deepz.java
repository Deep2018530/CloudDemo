package com.lanqiao.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author DeepSleeping
 * @date 2019/6/22 10:55
 * @description
 */
public class RandomRule_deepz extends AbstractLoadBalancerRule {

    /**
     * 总共被调用的次数，目前要求每台被调用5次
     */
    private int total = 0;
    /**
     * 当前提供服务的机器号
     */
    private int currentIndex = 0;

    public RandomRule_deepz() {
        super();
    }

    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            if (total < 5) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }

            if (server == null) {
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }
        return server;
    }
}
