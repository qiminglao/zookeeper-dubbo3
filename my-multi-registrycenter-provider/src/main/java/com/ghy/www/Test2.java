package com.ghy.www;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class Test2 {
    public static void main(String[] args) throws UnknownHostException, NoSuchFieldException, IllegalAccessException {
        InetSocketAddress a = new InetSocketAddress(InetAddress.getByName("192.168.3.188"), 2181);
        Field holder = a.getClass().getDeclaredField("holder");
        holder.setAccessible(true);
        Object o = holder.get(a);
        System.out.println(o.getClass().getName());
        Field hostname = o.getClass().getDeclaredField("hostname");
        hostname.setAccessible(true);
        hostname.set(o, null);

        System.out.println(a.getHostName());
        InetAddress abc;
    }
}
