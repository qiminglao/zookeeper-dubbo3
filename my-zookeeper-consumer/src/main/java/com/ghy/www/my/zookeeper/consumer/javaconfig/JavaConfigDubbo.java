package com.ghy.www.my.zookeeper.consumer.javaconfig;

import com.ghy.www.api.IService1;
import com.ghy.www.api.IService2;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    @DubboReference
    private IService1 service1;

    @DubboReference
    private IService2 service2;
}
