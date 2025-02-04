package com.euuen.glframework.math;


public class Vector4f extends org.joml.Vector4f {
    public Vector4f() {
        super();
    }

    public Vector4f(float x, float y, float z, float w){
        super(x, y, z, w);
    }

    public Vector4f(org.joml.Vector3f v){
        x = v.x;
        y = v.y;
        z = v.z;
        w = 0;
    }

    public Vector3f toV3f(){
        return new Vector3f(x, y, z);
    }

    @Override
    public Vector4f mul(float value){
        return new Vector4f(x * value, y * value, z * value, w * value);
    }

    public Vector4f mulLocal(float value){
        x *= value;
        y *= value;
        z *= value;
        w *= value;
        return this;
    }

}
