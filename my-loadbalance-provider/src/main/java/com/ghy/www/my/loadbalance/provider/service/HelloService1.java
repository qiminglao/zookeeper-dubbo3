package com.ghy.www.my.loadbalance.provider.service;

import com.ghy.www.api.IService1;
import org.springframework.beans.factory.annotation.Value;

public class HelloService1 implements IService1 {
    @Value("${server.port}")
    private int portValue;

    @Override
    public String getHello(String username) {
        System.out.println("HelloService1 portValue=" + portValue + " username=" + username);
        return "hello1 " + username + " port=" + portValue;
    }
}