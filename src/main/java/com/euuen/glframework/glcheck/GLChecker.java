package com.euuen.glframework.glcheck;

import org.lwjgl.opengl.GL43;

import static org.lwjgl.opengl.GL43.*;

public class GLChecker {
    public static void outShaderInfo(String name, int shader){
        System.out.println(name + ":" + glGetShaderInfoLog(shader));
    }

    public static void outProgramInfo(String name, int program){
        System.out.println(name + ":" + glGetProgramInfoLog(program));
    }

    public static void outGLErr(String name){
        int glErr = glGetError();
        switch (glErr){
            case GL43.GL_NO_ERROR -> {
                System.out.println(name + ":gl no err");
            }
            default -> {
                System.out.println(name + ":" + glErr);
            }
        }
    }
}
