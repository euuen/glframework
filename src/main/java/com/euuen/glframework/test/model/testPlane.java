package com.euuen.glframework.test.model;

import com.euuen.glframework.GLEngine;
import com.euuen.glframework.GLEngineSettings;
import com.euuen.glframework.camera.CameraControl;
import com.euuen.glframework.camera.CameraManager;
import com.euuen.glframework.input.InputManager;
import com.euuen.glframework.model.Plane;
import com.euuen.glframework.model.Triangle;
import com.euuen.glframework.scene.SceneManager;
import com.euuen.glframework.window.WindowManager;
import org.joml.Vector3f;

public class testPlane {
    public static void main(String[] args) {
        GLEngineSettings settings = new GLEngineSettings();
        settings.update_rate = 60;
        settings.window_width = 640;
        settings.window_height = 480;
        settings.window_title = "the Game Engine made by euuen";
        GLEngine glEngine = new GLEngine(settings);
        glEngine.startAsync();
        glEngine.waitForInit();
        CameraManager cameraManager = glEngine.cameraManager;
        WindowManager windowManager = glEngine.windowManager;
        cameraManager.camera.addControl(new CameraControl(cameraManager, windowManager));
        SceneManager sceneManager = glEngine.sceneManager;
        sceneManager.execute(() -> {
            Triangle triangle = new Triangle();
            triangle.move(new Vector3f(0, 0, 0));
            sceneManager.addModel(triangle);

            Plane plane = new Plane();
            plane.move(new Vector3f(0, 3, 0));
            sceneManager.addModel(plane);

            Plane plane2 = new Plane();
            plane2.move(new Vector3f(3, 3, 0));
            sceneManager.addModel(plane2);
        });
    }
}
