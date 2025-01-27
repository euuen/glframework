package com.euuen.glframework.model.material;

import static org.lwjgl.opengl.GL11.*;

public class PipelineSettings {
    // 要自行设置着色器的路径！！！
    public String vertex_shader = null;
    public String fragment_shader = null;

    public boolean enable_texture = false;
    public boolean enable_depth_test = true;
    public boolean enable_cull_face = false;
    public int depth_func = GL_LEQUAL;
    public int draw_mode = GL_TRIANGLES;
    public int front_face = GL_CW;
}
