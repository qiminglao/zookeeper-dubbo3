package com.ghy.www.my.timeout.provider.service;

import com.ghy.www.api.IService1;

public class HelloService1 implements IService1 {
    @Override
    public String getHello(String username) {
        System.out.println("begin " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("  end " + System.currentTimeMillis());
        return "hello1 " + username;
    }
}