package com.ghy.www.my.servicegroup.consumer.controller;

import com.ghy.www.api.IService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCcontroller {
    @Autowired
    @Qualifier("a")
    private IService1 service1_1;

    @Autowired
    @Qualifier("b")
    private IService1 service1_2;

    @RequestMapping("Test1")
    public String test1() {
        System.out.println("public String test1()");
        String helloString = service1_1.getHello("中国人1");
        return "返回信息：" + helloString;
    }

    @RequestMapping("Test2")
    public String test2() {
        System.out.println("public String test2()");
        String helloString = service1_2.getHello("中国人2");
        return "返回信息：" + helloString;
    }
}
