package com.ghy.www.my.fault.tolerant.provider.service;

import com.ghy.www.api.IService4;
import org.springframework.beans.factory.annotation.Value;

public class HelloService4 implements IService4 {
    @Value("${server.port}")
    private int portValue;

    @Override
    public String getHello(String username) {
        System.out.println("HelloService4 portValue=" + portValue + " username=" + username);
        try {
            if (username.equals("中国人4-2995") && portValue == 8085) {
                System.out.println("username.equals(\"中国人4-2995\") && portValue == 8085");
                Thread.sleep(Integer.MAX_VALUE);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello4 " + username + " port=" + portValue;
    }
}