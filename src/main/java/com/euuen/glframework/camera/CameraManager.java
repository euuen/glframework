package com.euuen.glframework.camera;

import com.euuen.application.Manager;
import com.euuen.glframework.GLEngineSettings;

public class CameraManager extends Manager {
    public GLEngineSettings settings;
    public Camera camera;
    public CameraManager(GLEngineSettings settings){
        this.settings = settings;
        camera = new Camera(settings);
    }
}
