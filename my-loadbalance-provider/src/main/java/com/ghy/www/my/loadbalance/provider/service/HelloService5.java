package com.ghy.www.my.loadbalance.provider.service;

import com.ghy.www.api.IService5;
import org.springframework.beans.factory.annotation.Value;

public class HelloService5 implements IService5 {
    @Value("${server.port}")
    private int portValue;

    @Override
    public String getHello(String username) {
        System.out.println("HelloService5 portValue=" + portValue + " username=" + username);
        return "hello5 " + username + " port=" + portValue;
    }
}