package com.euuen.rglframework;

import com.euuen.rapplication.System;

public class GLEngine extends System {
    @Override
    public void initialize() {
        // TODO Testing
        java.lang.System.out.println("hello GLEngine");
    }

    @Override
    public void update() {
        java.lang.System.out.println("updating");
    }

    @Override
    public void cleanup() {
        java.lang.System.out.println("bye GLEngine");
    }
}
