package com.ghy.www.my.multiple.versions.consumer.controller;

import com.ghy.www.api.IService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCcontroller {
    @Autowired
    @Qualifier("a")
    private IService1 service1_A;

    @Autowired
    @Qualifier("b_1")
    private IService1 service1_B_1;

    @Autowired
    @Qualifier("b_2")
    private IService1 service1_B_2;

    @RequestMapping("Test1")
    public String test1() {
        System.out.println("public String test1()");
        String helloString = service1_A.getHello("中国人A");
        return "返回信息：" + helloString;
    }

    @RequestMapping("Test2_1")
    public String test2_1() {
        System.out.println("public String test2_1()");
        String helloString = service1_B_1.getHello("中国人B_1");
        return "返回信息：" + helloString;
    }

    @RequestMapping("Test2_2")
    public String test2_2() {
        System.out.println("public String test2_2()");
        String helloString = service1_B_2.getHello("中国人B_2");
        return "返回信息：" + helloString;
    }
}
