package com.euuen.glframework.model;

import com.euuen.glframework.model.material.SimpleMaterial;

public class Plane extends Model{
    public Plane(){
        mesh = new Mesh();
        mesh.loadVertexBuffer(new float[]{
                -1, 1, 0,
                -1, -1, 0,
                1, -1, 0,
                1, -1, 0,
                1, 1, 0,
                -1, 1, 0,
        });
        material = new SimpleMaterial();
    }
}
