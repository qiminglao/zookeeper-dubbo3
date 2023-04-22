package com.ghy.www.my.token.consumer.javaconfig;

import com.ghy.www.api.IService1;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    /*@DubboReference(interfaceName = "com.ghy.www.api.IService1", url = "dubbo://127.0.0.1:20881")
    private IService1 service1;*/

    @DubboReference
    private IService1 service1;
}