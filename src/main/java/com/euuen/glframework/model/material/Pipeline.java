package com.euuen.glframework.model.material;

import com.euuen.glframework.camera.Camera;
import com.euuen.glframework.model.Model;
import com.euuen.just.Result;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryStack;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL43.*;
import com.euuen.jutils.ResourceLoader;

public class Pipeline {
    PipelineSettings settings;
    int vertexShader;
    int fragmentShader;
    int program;

    public Model model;
    public Camera camera;

    public static Result<Pipeline, String> genPipeline(PipelineSettings settings){
        Pipeline pipeline = new Pipeline();
        pipeline.settings = settings;
        pipeline.program = glCreateProgram();
        if (settings.vertex_shader != null){
            pipeline.vertexShader = glCreateShader(GL_VERTEX_SHADER);
            Result<String, String> result = ResourceLoader.readAll(pipeline, settings.vertex_shader);
            String source;
            if (result.resultType == Result.OK){
                source = result.Ok;
            }else {
                return new Result<Pipeline, String>().errOf("Pipeline: error vertex shader path");
            }
            glShaderSource(pipeline.vertexShader, source);
            glCompileShader(pipeline.vertexShader);
            glAttachShader(pipeline.program, pipeline.vertexShader);
        }
        if (settings.fragment_shader != null){
            pipeline.fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
            Result<String, String> result = ResourceLoader.readAll(pipeline, settings.fragment_shader);
            String source;
            if (result.resultType == Result.OK){
                source = result.Ok;
            }else {
                return new Result<Pipeline, String>().errOf("Pipeline: error fragment shader path");
            }
            glShaderSource(pipeline.fragmentShader, source);
            glCompileShader(pipeline.fragmentShader);
            glAttachShader(pipeline.program, pipeline.fragmentShader);
        }
        glLinkProgram(pipeline.program);
        return new Result<Pipeline, String>().okOf(pipeline);
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

    public void setParameterVec3f(String parameter, Vector3f value){
        activate();
        int location = glGetUniformLocation(program, parameter);
        try (MemoryStack stack = MemoryStack.stackPush()){
            FloatBuffer fb = value.get(stack.mallocFloat(3));
            glUniform3fv(location, fb);
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















