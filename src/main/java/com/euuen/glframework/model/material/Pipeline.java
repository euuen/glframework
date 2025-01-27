package com.euuen.glframework.model.material;

import com.euuen.glframework.camera.Camera;
import com.euuen.glframework.model.Model;
import org.joml.Matrix4f;
import org.lwjgl.system.MemoryStack;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.FloatBuffer;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.lwjgl.opengl.GL43.*;
import com.euuen.jutils.ResourceLoader;

public class Pipeline {
    PipelineSettings settings;
    int vertexShader;
    int fragmentShader;
    int program;

    public Model model;
    public Camera camera;

    public Pipeline(PipelineSettings settings){
        this.settings = settings;
        program = glCreateProgram();
        if (settings.vertex_shader != null){
            vertexShader = glCreateShader(GL_VERTEX_SHADER);
            String source = ResourceLoader.readAll(this, settings.vertex_shader).expect("[com.euuen.glframework.model.material.Pipeline]:please check your Vertex Shader's PATH");
            glShaderSource(vertexShader, source);
            glCompileShader(vertexShader);
            glAttachShader(program, vertexShader);
        }
        if (settings.fragment_shader != null){
            fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
            String source = ResourceLoader.readAll(this, settings.fragment_shader).expect("[com.euuen.glframework.model.material.Pipeline]:please check Fragment Shader's PATH");
            glShaderSource(fragmentShader, source);
            glCompileShader(fragmentShader);
            glAttachShader(program, fragmentShader);
        }
        glLinkProgram(program);
//        outShaderInfo("two", vertexShader);
//        outShaderInfo("three", fragmentShader);
//        outProgramInfo("four", program);
    }

    public void setParameter1f(String parameter, float value){
        activate();
        int location = glGetUniformLocation(program, parameter);
        glUniform1f(location, value);
        inactivate();
    }

    public void setParameterMatrix4f(String parameter, Matrix4f value) {
        activate();
        int location = glGetUniformLocation(program, parameter);
        try (MemoryStack stack = MemoryStack.stackPush()){
            FloatBuffer fb = value.get(stack.mallocFloat(16));
            glUniformMatrix4fv(location, false, fb);
        }
        inactivate();
    }

    public void activate(){
        glUseProgram(program);
    }

    public void inactivate(){
        glUseProgram(0);
    }

    public void loadModel(Model model){
        this.model = model;
    }

    public void unloadModel(){
        this.model = null;
    }

    public void loadCamera(Camera camera){
        this.camera = camera;
    }

    public void unloadCamera(){
        this.camera = null;
    }

    public void run(){
        Matrix4f projectionViewMatrix = camera.projectionViewMatrix();
        Matrix4f modelMatrix = model.modelMatrix();
        Matrix4f pmvMatrix = new Matrix4f();
        projectionViewMatrix.mul(modelMatrix, pmvMatrix);

        setParameterMatrix4f("pmvMatrix", pmvMatrix);

        model.mesh.activate();
        activate();

        if (settings.enable_depth_test) {
            glEnable(GL_DEPTH_TEST);
            glDepthFunc(settings.depth_func);
        } else {
            glDisable(GL_DEPTH_TEST);
        }
        glDrawArrays(settings.draw_mode, 0, model.mesh.num_vertex);
        inactivate();
        model.mesh.inactivate();
    }
}















