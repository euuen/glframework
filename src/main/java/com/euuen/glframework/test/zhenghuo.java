package com.euuen.glframework.test;

import com.euuen.glframework.GLEngine;
import com.euuen.glframework.GLEngineSettings;
import com.euuen.glframework.model.Triangle;
import com.euuen.glframework.scene.SceneManager;
import org.joml.Vector3f;

import static java.lang.Math.*;

public class zhenghuo {
    public Triangle triangle;
    public static void main(String[] args) {
        GLEngineSettings settings = new GLEngineSettings();
        settings.update_rate = 60;
        settings.window_width = 640;
        settings.window_height = 480;
        settings.window_title = "the Game Engine made by euuen";
        GLEngine glEngine = new GLEngine(settings);
        glEngine.startAsync();
        glEngine.waitForInit();
        SceneManager sceneManager = glEngine.sceneManager;
        float i = 0;
        zhenghuo zh = new zhenghuo();
        sceneManager.execute(() -> {
            zh.triangle = new Triangle();
            sceneManager.addModel(zh.triangle);
        });
        while (glEngine.isRunning){
            i += 0.1f;
            float y = 3f * ((float) sin(i));
            float x = 3f * ((float) cos(i + 0.3f));
            float z = 3f * ((float) cos((i)));
            sceneManager.execute(() -> zh.triangle.setPosition(new Vector3f(x, y, z)));
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}




