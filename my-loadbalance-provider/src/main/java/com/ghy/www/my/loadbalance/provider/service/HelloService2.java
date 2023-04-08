package com.ghy.www.my.loadbalance.provider.service;

import com.ghy.www.api.IService2;
import org.springframework.beans.factory.annotation.Value;

public class HelloService2 implements IService2 {
    @Value("${server.port}")
    private int portValue;

    @Override
    public String getHello(String username) {
        System.out.println("HelloService2 portValue=" + portValue + " username=" + username);
        return "hello2 " + username + " port=" + portValue;
    }
}