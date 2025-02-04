package com.euuen.glframework.scene;

import com.euuen.application.Manager;
import com.euuen.glframework.GLEngine;
import com.euuen.glframework.GLEngineSettings;
import com.euuen.glframework.camera.Camera;
import com.euuen.glframework.model.Model;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class SceneManager extends Manager {
    ArrayList<Model> models = new ArrayList<>();
    GLEngineSettings settings;
    GLEngine glEngine;
    public SceneManager(GLEngineSettings settings, GLEngine glEngine){
        this.settings = settings;
        this.glEngine = glEngine;
    }

    public void addModel(Model model){
        models.add(model);
    }

    @Override
    public void update() {
        super.update();
        Camera camera = glEngine.cameraManager.camera;
        glEngine.windowManager.getWindow().clear();
        for (Model model : models){
            model.render(camera);
        }
        glEngine.windowManager.getWindow().display();
    }
}





















