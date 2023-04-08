package com.ghy.www.my.fault.tolerant.provider.service;

import com.ghy.www.api.IService3;
import org.springframework.beans.factory.annotation.Value;

public class HelloService3 implements IService3 {
    @Value("${server.port}")
    private int portValue;

    @Override
    public String getHello(String username) {
        System.out.println("HelloService3 portValue=" + portValue + " username=" + username);
        try {
            if (portValue == 8085) {
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello3 " + username + " port=" + portValue;
    }
}