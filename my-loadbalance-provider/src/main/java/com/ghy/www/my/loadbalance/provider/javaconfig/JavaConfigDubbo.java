package com.ghy.www.my.loadbalance.provider.javaconfig;

import com.ghy.www.my.loadbalance.provider.service.*;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    @Bean
    //@DubboService(weight = 2)//8085
    // @DubboService(weight = 5)//8086
    @DubboService(weight = 10)//8087
    public HelloService1 getHelloService1() {
        return new HelloService1();
    }

    @Bean
    // @DubboService(weight = 2)//8085
    // @DubboService(weight = 5)//8086
    @DubboService(weight = 10)//8087
    public HelloService2 getHelloService2() {
        return new HelloService2();
    }

    @Bean
    @DubboService
    public HelloService3 getHelloService3() {
        return new HelloService3();
    }

    @Bean
    @DubboService
    public HelloService4 getHelloService4() {
        return new HelloService4();
    }

    @Bean
    @DubboService
    public HelloService5 getHelloService5() {
        return new HelloService5();
    }
}
