package com.ghy.www.my.loadbalance.consumer.javaconfig;

import com.ghy.www.api.*;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    @DubboReference(loadbalance = LoadbalanceRules.RANDOM)
    private IService1 service1;

    @DubboReference(loadbalance = LoadbalanceRules.ROUND_ROBIN)
    private IService2 service2;

    @DubboReference(loadbalance = LoadbalanceRules.LEAST_ACTIVE)
    private IService3 service3;

    @DubboReference(loadbalance = LoadbalanceRules.SHORTEST_RESPONSE)
    private IService4 service4;

    @DubboReference(loadbalance = LoadbalanceRules.CONSISTENT_HASH)
    private IService5 service5;
}
