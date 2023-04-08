package com.ghy.www.my.fault.tolerant.provider.service;

import com.ghy.www.api.IService9;
import org.springframework.beans.factory.annotation.Value;

public class HelloService9 implements IService9 {
    @Value("${server.port}")
    private int portValue;

    @Override
    public String getHello(String username) {
        System.out.println("HelloService9 portValue=" + portValue + " username=" + username + " " + System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello9 " + username + " port=" + portValue;
    }
}