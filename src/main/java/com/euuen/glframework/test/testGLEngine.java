package com.euuen.glframework.test;

import com.euuen.glframework.GLEngine;
import com.euuen.glframework.GLEngineSettings;

public class testGLEngine {
    public static void main(String[] args) {
        GLEngineSettings settings = new GLEngineSettings();
        settings.update_rate = 60;
        settings.window_width = 640;
        settings.window_height = 480;
        settings.window_title = "the Game Engine made by euuen";
        GLEngine glEngine = new GLEngine(settings);
        glEngine.start();
    }
}










