package com.ghy.www.my.fault.tolerant.provider.javaconfig;

import com.ghy.www.my.fault.tolerant.provider.service.*;
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

    @Bean
    @DubboService
    public HelloService6 getHelloService6() {
        return new HelloService6();
    }

    @Bean
    @DubboService
    public HelloService8 getHelloService8() {
        return new HelloService8();
    }

    @Bean
    @DubboService
    public HelloService9 getHelloService9() {
        return new HelloService9();
    }
}
