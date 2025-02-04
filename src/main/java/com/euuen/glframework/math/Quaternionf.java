package com.euuen.glframework.math;

import org.joml.Vector3f;

public class Quaternionf extends org.joml.Quaternionf {
    public Vector3f getDirection(){
        Vector3f result = new Vector3f();
        float norm = this.norm();
        if (norm != 1.0F) {
            norm = 1.0F / norm;
        }

        float xx = this.x * this.x * norm;
        float xz = this.x * this.z * norm;
        float xw = this.x * this.w * norm;
        float yy = this.y * this.y * norm;
        float yz = this.y * this.z * norm;
        float yw = this.y * this.w * norm;

        result.x = 2.0F * (xz + yw);
        result.y = 2.0F * (yz - xw);
        result.z = 1.0F - 2.0F * (xx + yy);

        return result;
    }

    public Vector3f getLeft(){
        Vector3f result = new Vector3f();
        float norm = this.norm();
        if (norm != 1.0F) {
            norm = 1.0F / norm;
        }

        float xy = this.x * this.y * norm;
        float xz = this.x * this.z * norm;
        float yy = this.y * this.y * norm;
        float yw = this.y * this.w * norm;
        float zz = this.z * this.z * norm;
        float zw = this.z * this.w * norm;

        result.x = 1.0F - 2.0F * (yy + zz);
        result.y = 2.0F * (xy + zw);
        result.z = 2.0F * (xz - yw);

        return result;
    }

    public Vector3f getUp(){
        Vector3f result = new Vector3f();

        float norm = this.norm();
        if (norm != 1.0F) {
            norm = 1.0F / norm;
        }

        float xx = this.x * this.x * norm;
        float xy = this.x * this.y * norm;
        float xz = this.x * this.z * norm;
        float xw = this.x * this.w * norm;
        float yy = this.y * this.y * norm;
        float yz = this.y * this.z * norm;
        float yw = this.y * this.w * norm;
        float zz = this.z * this.z * norm;
        float zw = this.z * this.w * norm;

        result.x = 2.0F * (xy - zw);
        result.y = 1.0F - 2.0F * (xx + zz);
        result.z = 2.0F * (yz + xw);

        return result;
    }

    public float norm(){
        return this.w * this.w + this.x * this.x + this.y * this.y + this.z * this.z;
    }
}
