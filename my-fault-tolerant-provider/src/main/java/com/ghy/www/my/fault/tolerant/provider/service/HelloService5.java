package com.ghy.www.my.fault.tolerant.provider.service;

import com.ghy.www.api.IService5;
import org.springframework.beans.factory.annotation.Value;

public class HelloService5 implements IService5 {
    @Value("${server.port}")
    private int portValue;

    @Override
    public String getHello(String username) {
        System.out.println("HelloService5 portValue=" + portValue + " username=" + username);
        try {
            if (portValue == 8085) {
                System.out.println("portValue == 8085");
                Thread.sleep(10000);
            }
            if (portValue == 8087) {
                System.out.println("portValue == 8087");
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello5 " + username + " port=" + portValue;
    }
}