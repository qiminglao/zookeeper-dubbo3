package com.ghy.www.my.multiple.versions.provider.javaconfig;

import com.ghy.www.my.multiple.versions.provider.service.HelloService1_A;
import com.ghy.www.my.multiple.versions.provider.service.HelloService1_B_1;
import com.ghy.www.my.multiple.versions.provider.service.HelloService1_B_2;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    @Bean
    @DubboService(group = "IServer1_A")
    public HelloService1_A getHelloService1() {
        return new HelloService1_A();
    }

    //使用version属性制定实现类的版本
    @Bean
    @DubboService(group = "IServer1_B_1", version = "IServer1_B_1.0")
    public HelloService1_B_1 getHelloService1_B_1() {
        return new HelloService1_B_1();
    }

    @Bean
    @DubboService(group = "IServer1_B_2", version = "IServer1_B_2.0")
    public HelloService1_B_2 getHelloService1_B_2() {
        return new HelloService1_B_2();
    }
}
