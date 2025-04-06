package com.euuen.rapplication.test;

import com.euuen.rapplication.Application;
import com.euuen.rapplication.Manager;

class Mgr1 extends Manager {
    @Override
    public void initialize() {
        super.initialize();
        System.out.println("initialize mgr1");
    }

    @Override
    public void update() {
        super.update();
        System.out.println("update mgr1");
    }

    @Override
    public void cleanup() {
        super.cleanup();
        System.out.println("cleanup mgr1");
    }
}

class Mgr2 extends Manager{
    @Override
    public void initialize() {
        super.initialize();
        System.out.println("initialize mgr2");
    }

    @Override
    public void update() {
        super.update();
        System.out.println("update mgr2");
    }

    @Override
    public void cleanup() {
        super.cleanup();
        System.out.println("cleanup mgr2");
    }
}

public class MyApp2 extends Application {
    int i = 0;

    public static void main(String[] args) {
        MyApp2 app = new MyApp2();
        app.start();
    }

    @Override
    public void initialize() {
        super.initialize();
        System.out.println("initialize myapp");
        addManager(new Mgr1());
        addManager(new Mgr2());
        System.out.println(Mgr2.class);
        System.out.println(Mgr1.class);
    }

    @Override
    public void update() {
        super.update();
        if (i == 1) {
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
