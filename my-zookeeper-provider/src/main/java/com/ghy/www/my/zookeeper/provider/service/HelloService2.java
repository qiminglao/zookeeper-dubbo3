package com.ghy.www.my.zookeeper.provider.service;

import com.ghy.www.api.IService2;

public class HelloService2 implements IService2 {
    @Override
    public String getHello(String username) {
        return "hello2 " + username;
    }
}