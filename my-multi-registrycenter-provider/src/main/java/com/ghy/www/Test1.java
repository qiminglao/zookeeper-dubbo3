package com.ghy.www;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {
    public static void main(String[] args) throws UnknownHostException {
        long begin = System.currentTimeMillis();
        InetAddress[] allByName = InetAddress.getAllByName("192.168.3.188");
        for (int i = 0; i < allByName.length; i++) {
            System.out.println(allByName[i]);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - begin) / 1000);
    }
}
