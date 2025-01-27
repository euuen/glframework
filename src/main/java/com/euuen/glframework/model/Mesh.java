package com.euuen.glframework.model;
import static org.lwjgl.opengl.GL43.*;

public class Mesh {
    public MeshSettings settings;
    public int num_vertex;
    public int vao;
    public int vertexBuffer;

    public Mesh(){
        this.settings = new MeshSettings();
        vao = glGenVertexArrays();
    }

    public Mesh(MeshSettings settings){
        this.settings = settings;
        vao = glGenVertexArrays();
    }

    public void loadVertexBuffer(float[] data){
        glBindVertexArray(vao);
        num_vertex = data.length/3;
        vertexBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vertexBuffer);
        glBufferData(GL_ARRAY_BUFFER, data, GL_STATIC_DRAW);
        glVertexAttribPointer(settings.index_vertex_buffer, 3, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(settings.index_vertex_buffer);
        glBindVertexArray(0);
    }

    public void activate(){
        glBindVertexArray(vao);
    }

    public void inactivate(){
        glBindVertexArray(0);
    }
}


























