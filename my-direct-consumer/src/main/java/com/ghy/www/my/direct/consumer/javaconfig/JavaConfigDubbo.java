package com.ghy.www.my.direct.consumer.javaconfig;

import com.ghy.www.api.IService1;
import com.ghy.www.api.IService2;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    @DubboReference(interfaceName = "com.ghy.www.api.IService1", url = "dubbo://192.168.3.188:20898")
    private IService1 service1;

    @DubboReference(interfaceName = "com.ghy.www.api.IService2", url = "dubbo://192.168.3.188:20898")
    private IService2 service2;
}