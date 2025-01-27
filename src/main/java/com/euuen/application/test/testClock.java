package com.euuen.application.test;

import com.euuen.application.Clock;

public class testClock {
    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        clock.setSleepRate(1);
        clock.start();
        while (true){
            System.out.println("hello clock");
            Thread.sleep(400);     //模拟耗时操作
            System.out.println(clock.optimal() - clock.getDuration());      // 需要休眠多长时间
            clock.sleep();
        }
    }
}
