package com.common.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡规则，不应再应用程序上下文中，避免被ComponentScan扫描到
 */
@Configuration
public class MyRule {
    /**
     * 配置负载均衡实现，--不写默认是轮训
     * IRule
     * RoundRobinRule 轮训
     * RandomRule 随机
     * AvailabilityFilteringRule 会先过滤掉，跳闸，访问故障的服务，对剩下的进行轮训
     * RetryRule:
     *
     */
    @Bean
    public IRule getRule(){
        return new KuangRandomRule();//随机

    }
}
