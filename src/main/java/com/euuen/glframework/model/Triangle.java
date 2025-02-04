package com.euuen.glframework.model;

import com.euuen.glframework.model.material.SimpleMaterial;
import com.euuen.glframework.model.material.UnshadedMaterial;
import org.joml.Vector3f;

public class Triangle extends Model{
    public Triangle(){
        mesh = new Mesh();
        mesh.loadVertexBuffer(new float[]{
            -1, 1, 0,
            -1, -1, 0,
            1, -1, 0,
        });
        material = new SimpleMaterial();
    }
}





















