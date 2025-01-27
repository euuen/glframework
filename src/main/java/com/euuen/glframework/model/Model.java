package com.euuen.glframework.model;

import com.euuen.glframework.camera.Camera;
import com.euuen.glframework.model.material.Material;
import com.euuen.glframework.model.material.Pipeline;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import java.util.Vector;

public class Model {
    public Mesh mesh;
    public Material material;
    public Vector3f position = new Vector3f();

    public Matrix4f modelMatrix(){
        return new Matrix4f().translate(position);
    }

    public void loadMesh(Mesh mesh){
        this.mesh = mesh;
    }

    public void loadMaterial(Material material){
        this.material = material;
    }

    public void render(Camera camera){
        Pipeline pipeline = material.getPipeline();
        pipeline.loadModel(this);
        pipeline.loadCamera(camera);

        pipeline.run();

        pipeline.unloadModel();
        pipeline.unloadCamera();
    }

    public void move(Vector3f delta){
        position.add(delta);
    }

    public void setPosition(Vector3f position){
        this.position = position;
    }
}


















