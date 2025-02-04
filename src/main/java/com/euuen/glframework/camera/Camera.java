package com.euuen.glframework.camera;

import com.euuen.application.Controllable;
import com.euuen.glframework.GLEngineSettings;
import com.euuen.glframework.math.Vector3f;
import com.euuen.glframework.math.Vector4f;
import com.jme3.math.Matrix3f;
import com.jme3.math.Quaternion;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public class Camera extends Controllable {
    public Vector3f position = new Vector3f(0, 0, 10);
    public Vector3f direction = new Vector3f(0, 0, -1);
    public Vector3f left = new Vector3f(-1, 0, 0);
    public Vector3f up = new Vector3f(0, 1, 0);
    public Matrix4f projection;
    public Camera(GLEngineSettings settings){
        float aspect = (float) settings.window_width / settings.window_height;
        projection = projectionMatrix(1.0472f, aspect, 0.1f, 1000f);
    }

    public Matrix4f viewMatrix(){
        Vector3f fwdVector = (Vector3f) new Vector3f().set(direction);
        Vector3f leftVector = (Vector3f) new Vector3f().set(fwdVector).cross(up);
        Vector3f upVector = (Vector3f) new Vector3f().set(leftVector).cross(fwdVector);
        return new Matrix4f(
                leftVector.x, leftVector.y, leftVector.z, -leftVector.dot(position),
                upVector.x, upVector.y, upVector.z, -upVector.dot(position),
                -fwdVector.x, -fwdVector.y, -fwdVector.z, fwdVector.dot(position),
                0, 0, 0, 1
        ).transpose();

//        System.out.println("111!!" + matrix4f);

//        Vector3f tmp_position = new Vector3f();
//        position.negate(tmp_position);
//        Quaternionf rotation = (Quaternionf) new Quaternionf().rotateXYZ(-rotX, -rotY, -rotZ);
//        System.out.println("222!!" + new Matrix4f().rotate(rotation).translate(tmp_position));
//        return new Matrix4f().rotate(rotation).translate(tmp_position);
    }

    public Matrix4f projectionMatrix(float fov, float aspect, float zNear, float zFar){
        return new Matrix4f().perspective(fov, aspect, zNear, zFar);
    }

    public Matrix4f projectionViewMatrix(){
        Matrix4f result = new Matrix4f();
        projection.mul(viewMatrix(), result);
        return result;
    }

    public void rotate(float angle, Vector3f axis){
        Quaternionf q = new Quaternionf().fromAxisAngleRad(axis, angle);
        Matrix4f rotation = new Matrix4f().rotate(q);
        Vector4f temp_direction = new Vector4f(direction);
        Vector4f temp_left = new Vector4f(left);
        Vector4f temp_up = new Vector4f(up);

        temp_direction.mul(rotation, temp_direction);
        temp_left.mul(rotation, temp_left);
        temp_up.mul(rotation, temp_up);

        direction = temp_direction.toV3f();
        left = temp_left.toV3f();
        up = temp_up.toV3f();
    }

    public void move(Vector3f delta){
        position.add(delta);
    }
}



