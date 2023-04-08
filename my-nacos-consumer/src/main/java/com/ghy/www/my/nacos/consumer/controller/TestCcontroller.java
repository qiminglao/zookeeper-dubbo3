package com.ghy.www.my.nacos.consumer.controller;

import com.ghy.www.api.IService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCcontroller {
    @Autowired
    private IService1 service1;

    @RequestMapping("Test1")
    public String test1() {
        System.out.println("public String test1()");
        String helloString = service1.getHello("中国人1");
        return "返回信息：" + helloString;
    }
}
