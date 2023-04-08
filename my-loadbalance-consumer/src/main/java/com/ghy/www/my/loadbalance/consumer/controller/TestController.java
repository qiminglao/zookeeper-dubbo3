package com.ghy.www.my.loadbalance.consumer.controller;

import com.ghy.www.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.CountDownLatch;

@RestController
public class TestController {
    @Autowired
    private IService1 service1;
    @Autowired
    private IService2 service2;
    @Autowired
    private IService3 service3;
    @Autowired
    private IService4 service4;
    @Autowired
    private IService5 service5;

    private int test1_provider1_runtime = 0;
    private int test1_provider2_runtime = 0;
    private int test1_provider3_runtime = 0;
    private int test1_allRuntime = 0;

    @RequestMapping("Test1")
    public void test1(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 0; i < 17; i++) {
            String helloString = service1.getHello("中国人" + (i + 1));
            System.out.println("public String test1() " + helloString);
            int runPort = Integer.parseInt(helloString.substring(helloString.length() - 4, helloString.length()));
            System.out.println(runPort);
            switch (runPort) {
                case 8085:
                    test1_provider1_runtime++;
                    break;
                case 8086:
                    test1_provider2_runtime++;
                    break;
                case 8087:
                    test1_provider3_runtime++;
                    break;
            }
            test1_allRuntime++;
            System.out.println("test1_allRuntime=" + test1_allRuntime);
            if (test1_allRuntime == 17) {
                System.out.println("test1_provider1_runtime=" + test1_provider1_runtime);
                System.out.println("test1_provider2_runtime=" + test1_provider2_runtime);
                System.out.println("test1_provider3_runtime=" + test1_provider3_runtime);
                test1_provider1_runtime = 0;
                test1_provider2_runtime = 0;
                test1_provider3_runtime = 0;
                test1_allRuntime = 0;
            }
        }
    }

    private int test2_provider1_runtime = 0;
    private int test2_provider2_runtime = 0;
    private int test2_provider3_runtime = 0;
    private int test2_allRuntime = 0;

    @RequestMapping("Test2")
    public void test2(HttpServletRequest request, HttpServletResponse response) {
        for (int i = 0; i < 17; i++) {
            String helloString = service2.getHello("中国人" + (i + 1));
            System.out.println("public String test2() " + helloString);
            int runPort = Integer.parseInt(helloString.substring(helloString.length() - 4, helloString.length()));
            System.out.println(runPort);
            switch (runPort) {
                case 8085:
                    test2_provider1_runtime++;
                    break;
                case 8086:
                    test2_provider2_runtime++;
                    break;
                case 8087:
                    test2_provider3_runtime++;
                    break;
            }
            test2_allRuntime++;
            System.out.println("test2_allRuntime=" + test2_allRuntime);
            if (test2_allRuntime == 17) {
                System.out.println("test2_provider1_runtime=" + test2_provider1_runtime);
                System.out.println("test2_provider2_runtime=" + test2_provider2_runtime);
                System.out.println("test2_provider3_runtime=" + test2_provider3_runtime);
                test2_provider1_runtime = 0;
                test2_provider2_runtime = 0;
                test2_provider3_runtime = 0;
                test2_allRuntime = 0;
            }
        }
    }

    private int test3_provider1_runtime = 0;
    private int test3_provider2_runtime = 0;
    private int test3_provider3_runtime = 0;

    class MyThread1 extends Thread {
        private int i;
        private CountDownLatch latch;

        public MyThread1(int i, CountDownLatch latch) {
            this.i = i;
            this.latch = latch;
        }

        @Override
        public void run() {
            String helloString = service3.getHello("中国人" + (i + 1));
            System.out.println("public String test3() " + helloString);
            int runPort = Integer.parseInt(helloString.substring(helloString.length() - 4, helloString.length()));
            System.out.println(runPort + " " + (i + 1) + "次运行");
            switch (runPort) {
                case 8085:
                    test3_provider1_runtime++;
                    break;
                case 8086:
                    test3_provider2_runtime++;
                    break;
                case 8087:
                    test3_provider3_runtime++;
                    break;
            }
            latch.countDown();
        }
    }

    @RequestMapping("Test3")
    public void test3(HttpServletRequest request, HttpServletResponse response) {
        CountDownLatch latch = new CountDownLatch(3000);
        for (int i = 0; i < 3000; i++) {
            MyThread1 t = new MyThread1(i, latch);
            t.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test3_provider1_runtime=" + test3_provider1_runtime);
        System.out.println("test3_provider2_runtime=" + test3_provider2_runtime);
        System.out.println("test3_provider3_runtime=" + test3_provider3_runtime);
    }

    private int test4_provider1_runtime = 0;
    private int test4_provider2_runtime = 0;
    private int test4_provider3_runtime = 0;

    class MyThread2 extends Thread {
        private int i;
        private CountDownLatch latch;

        public MyThread2(int i, CountDownLatch latch) {
            this.i = i;
            this.latch = latch;
        }

        @Override
        public void run() {
            String helloString = service4.getHello("中国人" + (i + 1));
            System.out.println("public String test4() " + helloString);
            int runPort = Integer.parseInt(helloString.substring(helloString.length() - 4, helloString.length()));
            System.out.println(runPort + " " + (i + 1) + "次运行");
            switch (runPort) {
                case 8085:
                    test4_provider1_runtime++;
                    break;
                case 8086:
                    test4_provider2_runtime++;
                    break;
                case 8087:
                    test4_provider3_runtime++;
                    break;
            }
            latch.countDown();
        }
    }

    @RequestMapping("Test4")
    public void test4(HttpServletRequest request, HttpServletResponse response) {
        CountDownLatch latch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            MyThread2 t = new MyThread2(i, latch);
            t.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test4_provider1_runtime=" + test4_provider1_runtime);
        System.out.println("test4_provider2_runtime=" + test4_provider2_runtime);
        System.out.println("test4_provider3_runtime=" + test4_provider3_runtime);
    }

    private int test5_provider1_runtime = 0;
    private int test5_provider2_runtime = 0;
    private int test5_provider3_runtime = 0;

    @RequestMapping("Test5")
    public void test5(HttpServletRequest request, HttpServletResponse response) {
        {
            String helloString = service5.getHello("a");
            System.out.println("public String test5() " + helloString);
            int runPort = Integer.parseInt(helloString.substring(helloString.length() - 4, helloString.length()));
            addRuntime(runPort);
        }
        {
            String helloString = service5.getHello("A");
            System.out.println("public String test5() " + helloString);
            int runPort = Integer.parseInt(helloString.substring(helloString.length() - 4, helloString.length()));
            addRuntime(runPort);
        }
        {
            String helloString = service5.getHello("我");
            System.out.println("public String test5() " + helloString);
            int runPort = Integer.parseInt(helloString.substring(helloString.length() - 4, helloString.length()));
            addRuntime(runPort);
        }
        {
            String helloString = service5.getHello("是");
            System.out.println("public String test5() " + helloString);
            int runPort = Integer.parseInt(helloString.substring(helloString.length() - 4, helloString.length()));
            addRuntime(runPort);
        }
        {
            String helloString = service5.getHello("中");
            System.out.println("public String test5() " + helloString);
            int runPort = Integer.parseInt(helloString.substring(helloString.length() - 4, helloString.length()));
            addRuntime(runPort);
        }
        {
            String helloString = service5.getHello("国");
            System.out.println("public String test5() " + helloString);
            int runPort = Integer.parseInt(helloString.substring(helloString.length() - 4, helloString.length()));
            addRuntime(runPort);
        }
        {
            String helloString = service5.getHello("人");
            System.out.println("public String test5() " + helloString);
            int runPort = Integer.parseInt(helloString.substring(helloString.length() - 4, helloString.length()));
            addRuntime(runPort);
        }
        System.out.println("test5_provider1_runtime=" + test5_provider1_runtime);
        System.out.println("test5_provider2_runtime=" + test5_provider2_runtime);
        System.out.println("test5_provider3_runtime=" + test5_provider3_runtime);
        test5_provider1_runtime = 0;
        test5_provider2_runtime = 0;
        test5_provider3_runtime = 0;
    }

    private void addRuntime(int runPort) {
        switch (runPort) {
            case 8085:
                test5_provider1_runtime++;
                break;
            case 8086:
                test5_provider2_runtime++;
                break;
            case 8087:
                test5_provider3_runtime++;
                break;
        }
    }
}
