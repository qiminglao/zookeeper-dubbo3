package com.ghy.www.my.zookeeper.consumer.controller;

import com.ghy.www.api.IService1;
import com.ghy.www.api.IService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCcontroller {

    @Autowired
    private IService1 service1;

    @Autowired
    private IService2 service2;

    @RequestMapping("Test1")
    public String test1() {
        System.out.println("public String test1()");
        String helloString = service1.getHello("中国人1");
        return "返回信息：" + helloString;
    }

    @RequestMapping("Test2")
    public String test2() {
        System.out.println("public String test2()");
        String helloString = service2.getHello("中国人2");
        return "返回信息：" + helloString;
    }
}
