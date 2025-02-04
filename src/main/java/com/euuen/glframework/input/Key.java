package com.euuen.glframework.input;
import static org.lwjgl.glfw.GLFW.*;

public class Key {
    public int key;
    public int action;
    public Key(int key){
        this.key = key;
    }
    public static boolean isKeyPressed(long handle, int key){
        return glfwGetKey(handle, key) == GLFW_PRESS;
    }
}





