package com.euuen.glframework;

import com.euuen.application.Application;
import com.euuen.glframework.camera.CameraManager;
import com.euuen.glframework.input.InputManager;
import com.euuen.glframework.scene.SceneManager;
import com.euuen.glframework.window.WindowManager;

public class GLEngine extends Application {
    private final GLEngineSettings settings;
    public WindowManager windowManager;
    public SceneManager sceneManager;
    public InputManager inputManager;
    public CameraManager cameraManager;

    public GLEngine(){
        settings = new GLEngineSettings();
        windowManager = new WindowManager(settings);
        sceneManager = new SceneManager(settings, this);
        inputManager = new InputManager(this);
        cameraManager = new CameraManager(settings);
        addManager(windowManager,
                sceneManager,
                inputManager,
                cameraManager);
    }

    public GLEngine(GLEngineSettings settings){
        this.settings = settings;
        windowManager = new WindowManager(settings);
        sceneManager = new SceneManager(settings, this);
        inputManager = new InputManager(this);
        cameraManager = new CameraManager(settings);
        addManager(windowManager,
                sceneManager,
                inputManager,
                cameraManager);
    }

    public void start(){
        super.start();
    }

    public void stop(){
        super.stop();
    }

    @Override
    public void initialize() {
        clock.setSleepRate(settings.update_rate);
        System.out.println("GLEngine - made by com.euuen.euuen - version : 1.0.0");
    }
}
