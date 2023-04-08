package com.ghy.www.my.multiple.versions.consumer.javaconfig;

import com.ghy.www.api.IService1;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    @DubboReference(group = "IServer1_A")
    private IService1 service1;

    @DubboReference(group = "IServer1_B_1", version = "IServer1_B_1.0")
    private IService1 service1_B_1;

    @DubboReference(group = "IServer1_B_2", version = "IServer1_B_2.0")
    private IService1 service1_B_2;

    @Bean("a")
    public IService1 getService1() {
        return service1;
    }

    @Bean("b_1")
    public IService1 getService1_B_1() {
        return service1_B_1;
    }

    @Bean("b_2")
    public IService1 getService1_B_2() {
        return service1_B_2;
    }
}
