package com.euuen.application.test;

import com.euuen.application.Application;
import com.euuen.application.Manager;

public class testApplication extends Application {
    int i = 0;
    @Override
    public void initialize() {
        super.initialize();
        System.out.println("hello amc");
    }

    @Override
    public void update() {
        super.update();
        if (i==3){
            stop();
            return;
        }
        System.out.println("updating");
        i++;
    }

    @Override
    public void clean() {
        super.clean();
        System.out.println("cleanup");
    }

    public static void main(String[] args) {
        testApplication app = new testApplication();
        app.start();
    }
}























