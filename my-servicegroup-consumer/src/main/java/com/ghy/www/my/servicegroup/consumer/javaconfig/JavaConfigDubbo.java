package com.ghy.www.my.servicegroup.consumer.javaconfig;

import com.ghy.www.api.IService1;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigDubbo {
    //引用别名为IServer1_A的IService1接口的实现类
    @DubboReference(group = "IServer1_A")
    private IService1 service1;

    //引用别名为IServer1_B的IService1接口的实现类
    @DubboReference(group = "IServer1_B")
    private IService1 service2;

    //再另起别名a，在控制层中引用别名a的对象
    @Bean("a")
    public IService1 getService1() {
        return service1;
    }

    //再另起别名b，在控制层中引用别名b的对象
    @Bean("b")
    public IService1 getService2() {
        return service2;
    }
}
