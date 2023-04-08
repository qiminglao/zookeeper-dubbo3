package com.ghy.www.my.check1.javaconfig;

import com.ghy.www.api.IService1;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    @DubboReference
    private IService1 service1;
}
