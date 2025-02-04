package com.euuen.glframework.model.material;

import com.euuen.just.Result;

public class UnshadedMaterial extends Material{
    public Pipeline pipeline;
    public UnshadedMaterial(){
        PipelineSettings pipelineSettings = new PipelineSettings();
        pipelineSettings.vertex_shader = "assets/triangle.vert";
        pipelineSettings.fragment_shader = "assets/triangle.frag";
        pipeline = Pipeline.genPipeline(pipelineSettings).expect("error java setting: GLEngine cannot access shader files");
    }

    public Pipeline getPipeline() {
        return pipeline;
    }
}























