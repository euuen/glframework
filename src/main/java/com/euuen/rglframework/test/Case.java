package com.euuen.rglframework.test;

import com.euuen.rapplication.Application;
import com.euuen.rglframework.GLEngine;

public class Case extends Application {
    @Override
    public void initialize() {
        addSystem(new GLEngine());
    }

    @Override
    public void update(){
        stop();
    }

    public static void main(String[] args) {
        Case _case = new Case();
        _case.start();
    }
}
