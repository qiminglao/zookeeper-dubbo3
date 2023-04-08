package com.ghy.www.my.providercluster.provider.service;

import com.ghy.www.api.IService1;
import org.springframework.beans.factory.annotation.Value;

public class HelloService implements IService1 {
    @Value("${server.port}")
    private int portValue;

    @Override
    public String getHello(String username) {
        String returnString = "hello " + username + " port=" + portValue;
        System.out.println(returnString);
        return returnString;
    }
}