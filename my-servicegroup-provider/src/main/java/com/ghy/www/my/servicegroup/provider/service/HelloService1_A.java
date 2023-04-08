package com.ghy.www.my.servicegroup.provider.service;

import com.ghy.www.api.IService1;

public class HelloService1_A implements IService1 {
    @Override
    public String getHello(String username) {
        return "helloA " + username;
    }
}