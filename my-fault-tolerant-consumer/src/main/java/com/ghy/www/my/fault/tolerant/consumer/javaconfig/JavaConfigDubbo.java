package com.ghy.www.my.fault.tolerant.consumer.javaconfig;

import com.ghy.www.api.*;
import org.apache.dubbo.common.constants.ClusterRules;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    @DubboReference(cluster = ClusterRules.FAIL_OVER)
    private IService1 service1;

    @DubboReference(cluster = ClusterRules.FAIL_FAST)
    private IService2 service2;

    @DubboReference(cluster = ClusterRules.FAIL_SAFE)
    private IService3 service3;

    @DubboReference(cluster = ClusterRules.FAIL_BACK)
    private IService4 service4;

    @DubboReference(cluster = ClusterRules.FORKING)
    private IService5 service5;

    @DubboReference(cluster = ClusterRules.BROADCAST)
    private IService6 service6;

    @DubboReference(cluster = ClusterRules.FAIL_OVER, retries = 5)
    private IService8 service8;

    @DubboReference(cluster = ClusterRules.FAIL_BACK, retries = 5)
    private IService9 service9;
}
