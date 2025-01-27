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
    CopyOnWriteArrayList<Runnable> tasks = new CopyOnWriteArrayList<>();
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
        for (Runnable task : tasks){
            task.run();
        }
        tasks.clear();

        Camera camera = glEngine.cameraManager.camera;
        glEngine.windowManager.getWindow().clear();
        for (Model model : models){
            model.render(camera);
        }
        glEngine.windowManager.getWindow().display();
    }

    // 为多线程环境而准备
    public void execute(Runnable task){
        tasks.add(task);
    }
}





















