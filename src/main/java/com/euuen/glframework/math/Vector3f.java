package com.euuen.glframework.math;

public class Vector3f extends org.joml.Vector3f {
    public Vector3f(float x, float y, float z){
        super(x, y, z);
    }

    public Vector3f() {
        super();
    }

    @Override
    public Vector3f mul(float value){
        return new Vector3f(x*value, y*value, z*value);
    }

    public Vector3f mulLocal(float value){
        x *= value;
        y *= value;
        z *= value;
        return this;
    }
}
