package com.euuen.glframework.input;

import com.euuen.application.Manager;
import com.euuen.glframework.GLEngine;
import com.euuen.glframework.window.Window;
import org.lwjgl.glfw.GLFWKeyCallbackI;

import java.util.ArrayList;
import java.util.HashMap;

import static org.lwjgl.glfw.GLFW.*;

public class InputManager extends Manager implements GLFWKeyCallbackI {
    public GLEngine glEngine;
    public Window window;
    public HashMap<Event, String> eventMap = new HashMap<>();
    public HashMap<String, ArrayList<Listener>> listenerMap = new HashMap<>();

    public InputManager(GLEngine glEngine){
        this.glEngine = glEngine;
    }

    @Override
    public void initialize() {
        super.initialize();
        window = glEngine.windowManager.getWindow();
        long handle = window.getHandle();
        glfwSetKeyCallback(handle, this);
    }

    @Override
    public void update() {
        super.update();
        // TODO add handler
        window.pollEvents();
        if (window.shouldClose()){
            glEngine.stop();
        }
    }

    @Override
    public void invoke(long windowHandle, int key, int scancode, int action, int mods) {
        for (Event event : eventMap.keySet()){
            if (event.trigger(key, action)){
                String mapping = eventMap.get(event);
                for (Listener listener : listenerMap.get(mapping)){
                    listener.invoke(mapping, event);
                }
            }
        }
    }

    public void addMapping(Event event, String mapping){
        execute(() -> eventMap.put(event, mapping));

    }

    public void addListener(Listener listener, String ... mappings){
        execute(() -> {
            for (String mapping : mappings){
                if (!listenerMap.containsKey(mapping))  listenerMap.put(mapping, new ArrayList<>());
                listenerMap.get(mapping).add(listener);
            }
        });
    }
}







