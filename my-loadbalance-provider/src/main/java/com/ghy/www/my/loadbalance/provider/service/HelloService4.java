package com.ghy.www.my.loadbalance.provider.service;

import com.ghy.www.api.IService4;
import org.springframework.beans.factory.annotation.Value;

public class HelloService4 implements IService4 {
    @Value("${server.port}")
    private int portValue;

    @Override
    public String getHello(String username) {
        System.out.println("HelloService4 portValue=" + portValue + " username=" + username);
        return "hello4 " + username + " port=" + portValue;
    }
}