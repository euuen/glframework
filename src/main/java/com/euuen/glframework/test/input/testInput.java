package com.euuen.glframework.test.input;

import com.euuen.glframework.GLEngine;
import com.euuen.glframework.GLEngineSettings;
import com.euuen.glframework.input.Event;
import com.euuen.glframework.input.InputManager;
import com.euuen.glframework.input.KeyTrigger;
import com.euuen.glframework.input.Listener;
import com.euuen.glframework.model.Triangle;
import com.euuen.glframework.scene.SceneManager;
import org.checkerframework.checker.units.qual.K;

import static org.lwjgl.glfw.GLFW.*;

public class testInput extends GLEngine{
    public static void main(String[] args) {
        GLEngineSettings settings = new GLEngineSettings();
        settings.update_rate = 60;
        settings.window_width = 640;
        settings.window_height = 480;
        settings.window_title = "the Game Engine made by euuen";
        GLEngine glEngine = new GLEngine(settings);
        glEngine.after(()->{
            SceneManager sceneManager = glEngine.sceneManager;
            sceneManager.addModel(new Triangle());

            InputManager inputManager = glEngine.inputManager;
            inputManager.addMapping(new Event(new KeyTrigger(GLFW_KEY_A)), "test");
            inputManager.addMapping(new Event(new KeyTrigger(GLFW_KEY_W)), "fuck");
            inputManager.addListener(new Listener() {
                @Override
                public void invoke(String mapping, Event event) {
                    if (event.action != GLFW_PRESS) return ;
                    if (mapping.equals("test")){
                        System.out.println("ok");
                    }else {
                        System.out.println("err");
                    }
                }
            }, "test", "fuck");
        });
        glEngine.start();
    }
}












