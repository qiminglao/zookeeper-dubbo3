package com.ghy.www.my.direct.provider.javaconfig;

import com.ghy.www.my.direct.provider.service.HelloService1;
import com.ghy.www.my.direct.provider.service.HelloService2;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    @Bean
    @DubboService
    public HelloService1 getHelloService1() {
        return new HelloService1();
    }

    @Bean
    @DubboService
    public HelloService2 getHelloService2() {
        return new HelloService2();
    }
}
