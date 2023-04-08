package com.ghy.www.my.fault.tolerant.provider.service;

import com.ghy.www.api.IService8;
import org.springframework.beans.factory.annotation.Value;

public class HelloService8 implements IService8 {
    @Value("${server.port}")
    private int portValue;

    @Override
    public String getHello(String username) {
        System.out.println("HelloService8 portValue=" + portValue + " username=" + username + " " + System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello8 " + username + " port=" + portValue;
    }
}