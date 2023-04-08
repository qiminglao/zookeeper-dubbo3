package com.ghy.www.my.implicit.parameters.provider.service;

import com.ghy.www.api.IService1;
import com.ghy.www.dto.UserinfoDTO;
import org.apache.dubbo.rpc.RpcContext;

public class HelloService1 implements IService1 {
    @Override
    public String getHello(String username) {
        UserinfoDTO userinfoDTO = (UserinfoDTO) RpcContext.getServiceContext().getObjectAttachment("myUserinfoDTO");
        System.out.println(userinfoDTO.getId() + " " + userinfoDTO.getUsername() + " " + userinfoDTO.getPassword() + " " + userinfoDTO.getAge() + " " + userinfoDTO.getInsertdate());
        return "hello1 " + username;
    }
}