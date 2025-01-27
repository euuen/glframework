package com.euuen.glframework.window;

import com.euuen.glframework.GLEngineSettings;
import org.lwjgl.glfw.GLFWErrorCallback;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.opengl.GL43.*;

public class Window {
    GLEngineSettings settings;
    long handle;
    public Window(GLEngineSettings settings){
        this.settings = settings;

        GLFWErrorCallback.createPrint(System.err).set();
        glfwInit();

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, settings.gl_major);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, settings.gl_minor);
        handle = glfwCreateWindow(settings.window_width, settings.window_height, settings.window_title, 0, 0);
        glfwMakeContextCurrent(handle);
        createCapabilities();
    }

    public long getHandle(){
        return handle;
    }

    public void pollEvents(){
        glfwPollEvents();
    }

    public void clear(){
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public void display(){
        glfwSwapBuffers(handle);
    }

    public void open(){
        glfwShowWindow(handle);
    }

    public void close(){
        glfwDestroyWindow(handle);
    }

    public void clean(){
        glfwTerminate();
    }

    public boolean shouldClose(){
        return glfwWindowShouldClose(handle);
    }
}






















