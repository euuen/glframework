package com.euuen.glframework.model.material;

import org.joml.Vector3f;

public class SimpleMaterial extends Material{
    Pipeline pipeline;

    public SimpleMaterial(){
        PipelineSettings settings = new PipelineSettings();
        settings.vertex_shader = "assets/simple.vert";
        settings.fragment_shader = "assets/simple.frag";
        pipeline = Pipeline.genPipeline(settings).expect("error java setting: GLEngine cannot access shader files");
        pipeline.setParameterVec3f("color", new Vector3f(1, 1, 1));
    }

    @Override
    public Pipeline getPipeline() {
        return pipeline;
    }

    public void setColorRGB(float r, float g, float b){
        Vector3f color = new Vector3f(r, g, b);
        pipeline.setParameterVec3f("color", color);
    }
}
