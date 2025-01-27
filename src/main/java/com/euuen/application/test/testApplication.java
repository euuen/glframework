package com.euuen.application.test;

import com.euuen.application.Application;
import com.euuen.application.Manager;

public class testApplication extends Application {
    public testApplication(){
        super(new Adder());
    }

    public static void main(String[] args) {
        testApplication application = new testApplication();
        application.setUpdateRate(1);
        application.start();
    }

    @Override
    public void initialize() {

    }

    @Override
    public void update(){
        super.update();
        System.out.println("hello application");
    }
}

class Adder extends Manager{
    private int number;

    @Override
    public void initialize() {
        number = 0;
    }

    @Override
    public void update() {
        super.update();
        System.out.println(number);
        number++;
    }
}






















