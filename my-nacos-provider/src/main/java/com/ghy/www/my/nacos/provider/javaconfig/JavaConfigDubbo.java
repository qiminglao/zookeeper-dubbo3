package com.ghy.www.my.nacos.provider.javaconfig;

import com.ghy.www.my.nacos.provider.service.HelloService1;
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
}
