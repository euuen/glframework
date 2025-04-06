package com.euuen.rapplication.test;

import com.euuen.rapplication.Application;

public class MyApp extends Application {
    int i = 0;
    public static void main(String[] args) {
        MyApp app = new MyApp();
        app.start();
    }

    @Override
    public void initialize() {
        super.initialize();
        System.out.println("initialize myapp");
    }

    @Override
    public void update() {
        super.update();
        if (i == 3) {
            stop();
        }
        System.out.println("update myapp");
        i++;
    }

    @Override
    public void cleanup() {
        super.cleanup();
        System.out.println("cleanup myapp");
    }
}
