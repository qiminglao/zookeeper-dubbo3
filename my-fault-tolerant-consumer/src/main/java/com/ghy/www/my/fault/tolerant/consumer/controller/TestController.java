package com.ghy.www.my.fault.tolerant.consumer.controller;

import com.ghy.www.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {
    @Autowired
    private IService1 service1;
    @Autowired
    private IService2 service2;
    @Autowired
    private IService3 service3;
    @Autowired
    private IService4 service4;
    @Autowired
    private IService5 service5;
    @Autowired
    private IService6 service6;
    @Autowired
    private IService8 service8;
    @Autowired
    private IService9 service9;

    @RequestMapping("Test1")
    public String test1() {
        String helloString = service1.getHello("中国人1");
        System.out.println("public String test1() " + helloString);
        return "返回信息：" + helloString;
    }

    @RequestMapping("Test2")
    public String test2() {
        String helloString = service2.getHello("中国人2");
        System.out.println("public String test2() " + helloString);
        return "返回信息：" + helloString;
    }

    @RequestMapping("Test3")
    public String test3() {
        String helloString = service3.getHello("中国人3");
        System.out.println("public String test3() " + helloString);
        return "返回信息：" + helloString;
    }

    @RequestMapping("Test4")
    public void test4(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 0; i < 3000; i++) {
            String helloString = service4.getHello("中国人4-" + (i + 1));
            System.out.println("public String test4() " + helloString + " i=" + (i + 1));
            Thread.yield();
        }
    }

    @RequestMapping("Test5")
    public String test5() {
        String helloString = service5.getHello("中国人5");
        System.out.println("public String test5() " + helloString);
        return "返回信息：" + helloString;
    }

    @RequestMapping("Test6")
    public String test6() {
        String helloString = service6.getHello("中国人6");
        System.out.println("public String test6() " + helloString);
        return "返回信息：" + helloString;
    }

    @RequestMapping("Test1_Diff")
    public String test1_Diff() {
        String helloString = service8.getHello("中国人8");
        System.out.println("public String test1_Diff() " + helloString);
        return "返回信息：" + helloString;
    }

    @RequestMapping("Test4_Diff")
    public String test4_Diff() {
        String helloString = service9.getHello("中国人9");
        System.out.println("public String test4_Diff() " + helloString);
        return "返回信息：" + helloString;
    }
}