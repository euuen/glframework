package com.euuen.main.test;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class testEventBus {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new Sub1());
        eventBus.register(new Sub2());
        eventBus.post("event");
        eventBus.post("event2");

    }
}

class Sub1{
    @Subscribe
    public void handle(String a){
        System.out.println("1:" + a);
    }

    @Subscribe
    public void handle2(String a){
        System.out.println("111:" + a);
    }
}

class Sub2{
    @Subscribe
    public void handle(String a){
        System.out.println("2:" + a);
    }
}


