package com.ghy.www.my.implicit.parameters.consumer.controller;

import com.ghy.www.api.IService1;
import com.ghy.www.dto.UserinfoDTO;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestCcontroller {

    @Autowired
    private IService1 service1;

    @RequestMapping("Test1")
    public String test1() {
        System.out.println("public String test1()");
        UserinfoDTO userinfoDTO = new UserinfoDTO();
        userinfoDTO.setId(100);
        userinfoDTO.setUsername("中国");
        userinfoDTO.setPassword("中国人");
        userinfoDTO.setAge(100);
        userinfoDTO.setInsertdate(new Date());

        RpcContext.getServiceContext().setObjectAttachment("myUserinfoDTO", userinfoDTO);
        String helloString = service1.getHello("中国人1");
        return "返回信息：" + helloString;
    }
}
