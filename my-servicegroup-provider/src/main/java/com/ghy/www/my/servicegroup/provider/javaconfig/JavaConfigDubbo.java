package com.ghy.www.my.servicegroup.provider.javaconfig;

import com.ghy.www.my.servicegroup.provider.service.HelloService1_A;
import com.ghy.www.my.servicegroup.provider.service.HelloService1_B;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    // group值IServer1_A代表HelloService1_A类是IService1接口的其中一个实现类
    @Bean
    @DubboService(group = "IServer1_A")
    public HelloService1_A getHelloService1() {
        return new HelloService1_A();
    }

    // group值IServer1_B代表HelloService1_B类是IService1接口的其中一个实现类
    @Bean
    @DubboService(group = "IServer1_B")
    public HelloService1_B getHelloService2() {
        return new HelloService1_B();
    }

    // 使用group来标识出实现同一个接口的不同实现类
    // 相当于使用group属性给实现类起了一个别名
}
