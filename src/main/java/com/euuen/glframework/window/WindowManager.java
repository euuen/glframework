package com.euuen.glframework.window;

import com.euuen.application.Manager;
import com.euuen.glframework.GLEngineSettings;

public class WindowManager extends Manager {
    GLEngineSettings settings;
    Window window;

    public WindowManager(GLEngineSettings settings){
        this.settings = settings;
    }

    public Window getWindow() {
        return window;
    }

    @Override
    public void initialize() {
        window = new Window(settings);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void cleanup() {
        super.cleanup();
        window.close();
    }
}
























