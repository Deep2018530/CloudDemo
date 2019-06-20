## 微服务的定义
> 微服务化的核心就是将传统的一站式应用，根据业务拆分成一个一个的服务，彻底地去耦合，每一个微服务提供单个
业务功能的服务，一个服务做一件事，从技术角度看就是一种小而独立的处理过程，类似进程概念,能够自行单独启动或销毁，拥有自己独立的数据库。

## 基础知识
### 1.Eureka服务注册与发现  
        eureka自我保护机制:某一时刻某一个微服务不可用了，eureka不会立刻清理，依旧会对该微服务的信息进性保存，默认情况下，如果EurekaServer在一定时间内没有接收到  
    某个微服务实例的心跳，EurekaServer将会注销该实例(默认90秒)。Eureka通过“自我保护模式”来解决网络故障导致微服务无法与EurekaServer之间通信的问题  
    ——当EurekaServer节点在短时间内丢失过多客户端时(可能发生了网络分区故障),那么这个节点就会进入自我保护模式。一旦进入该模式，EurekaServer就会保护服务注册表中的信息，
    不再删除服务注册表中的数据(也就是不会注销任何微服务)。当网络故障恢复后，该EurekaServer节点会自动退出自我保护模式。  
    它的设计哲学就是宁可保留错误的服务注册信息，也不盲目注销任何可能健康的服务实例。     
### 2. Ribbon负载均衡  
> SpringCloud Ribbon是基于Ntflix Ribbon实现的一套客户端 负载均衡的工具。  

> 负载均衡算法策略重要接口: IRule
* `RoubdRobinRule`    轮询
* `RandomRule`        随机
* `AvailabilityFilteringRule` 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，
还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问。
* `WeightedResponseTimeRule`  根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大，
被选中的概率越高。刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够，会切换到WeightedResponseTimeRule
* `RetryRule` 先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用服务。
* `BestAvailableRule` 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务。
* `ZoneAvoidanceRule` 默认规则，复合判断server所在区域的性能和server的可用性选择服务器

> Ribbon其实就是一个软负载均衡的客户端组件，它可以和其它所需请求的客户端结合使用，和eureka结合只是其中的一个实例。  
### 3. Feign负载均衡  
### 4. Hystrix断路器  
### 5. zuul路由网关  
### 6. SpringCloud Config分布式配置中心

## 问题
* 作为服务注册中心，Eureka比Zookeeper好在哪里?

            著名的CAP理论指出，一个分布式系统不可能同时满足C（一致性）、A（可用性）和P（分区容错性）。
        由于分区容错性P是在分布式系统中必须要保证的，因此我们只能在A和C之间进行权衡
        `Zookeeper`保证的是`CP`，`Eureka`则是`AP`。
        因此：`Eureka可以很好的应对因网络故障导致部分节点失去联系的情况，而不会像zookeeper那样使整个注册服务瘫痪。`

## sql  
```mysql
    DATABASE()函数： 获取当前数据库名称
```