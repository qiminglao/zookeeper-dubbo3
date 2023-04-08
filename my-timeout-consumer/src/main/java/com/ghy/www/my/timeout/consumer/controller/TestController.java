package com.ghy.www.my.timeout.consumer.controller;

import com.ghy.www.api.IService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {
    @Autowired
    private IService1 service1;

    @RequestMapping("Test1")
    public String test1() {
        System.out.println("public String test1()");
        String helloString = service1.getHello("中国人1");
        return "返回信息：" + helloString;
    }

    class MyThread extends Thread {
        private int i;

        public MyThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("public String test1()");
            String helloString = service1.getHello("中国人" + i);
        }
    }

    @RequestMapping("Test2")
    public void Test2(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 0; i < 300; i++) {
            MyThread t = new MyThread(i + 1);
            t.start();
        }
    }
}
