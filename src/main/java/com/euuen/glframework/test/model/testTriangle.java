package com.euuen.glframework.test.model;

import com.euuen.glframework.GLEngine;
import com.euuen.glframework.GLEngineSettings;
import com.euuen.glframework.input.Event;
import com.euuen.glframework.input.InputManager;
import com.euuen.glframework.input.KeyTrigger;
import com.euuen.glframework.input.Listener;
import com.euuen.glframework.model.Triangle;
import com.euuen.glframework.scene.SceneManager;
import org.checkerframework.checker.units.qual.K;
import org.joml.Vector3f;

import static org.lwjgl.glfw.GLFW.*;

public class testTriangle{
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
        sceneManager.execute(() -> {
            Triangle triangle = new Triangle();
            triangle.move(new Vector3f(0, 5, 0));
            sceneManager.addModel(triangle);
        });
    }
}












