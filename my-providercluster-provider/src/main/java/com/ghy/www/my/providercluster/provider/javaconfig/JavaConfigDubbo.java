package com.ghy.www.my.providercluster.provider.javaconfig;

import com.ghy.www.my.providercluster.provider.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    @Bean
    @DubboService
    public HelloService getHelloService1() {
        return new HelloService();
    }
}