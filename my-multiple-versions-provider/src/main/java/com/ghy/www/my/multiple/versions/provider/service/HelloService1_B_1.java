package com.ghy.www.my.multiple.versions.provider.service;

import com.ghy.www.api.IService1;

public class HelloService1_B_1 implements IService1 {
    @Override
    public String getHello(String username) {
        return "helloB_1 " + username;
    }
}