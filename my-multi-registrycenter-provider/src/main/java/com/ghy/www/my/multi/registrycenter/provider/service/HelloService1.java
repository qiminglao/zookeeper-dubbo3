package com.ghy.www.my.multi.registrycenter.provider.service;

import com.ghy.www.api.IService1;

public class HelloService1 implements IService1 {
    @Override
    public String getHello(String username) {
        return "hello1 " + username;
    }
}