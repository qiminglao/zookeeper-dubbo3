package com.ghy.www.my.timeout.consumer.javaconfig;

import com.ghy.www.api.IService1;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    @DubboReference(retries = 0, timeout = 6000000)
    private IService1 service1;
}