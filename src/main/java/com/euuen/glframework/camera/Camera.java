package com.euuen.glframework.camera;

import com.euuen.glframework.GLEngineSettings;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Camera {
    public Vector3f position = new Vector3f(0, 0, 10);
    public Matrix4f projection;
    public Camera(GLEngineSettings settings){
        float aspect = (float) settings.window_width / settings.window_height;
        projection = new Matrix4f().perspective(1.0472f, aspect, 0.1f, 1000f);
    }

    public Matrix4f viewMatrix(){
        Vector3f tmp_position = new Vector3f();
        position.negate(tmp_position);
        return new Matrix4f().translate(tmp_position);
    }

    public Matrix4f projectionViewMatrix(){
        Matrix4f result = new Matrix4f();
        projection.mul(viewMatrix(), result);
        return result;
    }
}
