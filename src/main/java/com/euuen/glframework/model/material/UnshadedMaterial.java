package com.euuen.glframework.model.material;

public class UnshadedMaterial extends Material{
    public Pipeline pipeline;
    public UnshadedMaterial(){
        PipelineSettings pipelineSettings = new PipelineSettings();
        pipelineSettings.vertex_shader = "assets/triangle.vert";
        pipelineSettings.fragment_shader = "assets/triangle.frag";
        pipeline = new Pipeline(pipelineSettings);
    }

    public Pipeline getPipeline() {
        return pipeline;
    }
}























