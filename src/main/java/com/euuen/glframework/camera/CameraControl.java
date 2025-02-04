package com.euuen.glframework.camera;

import com.euuen.application.Control;
import com.euuen.glframework.input.Event;
import com.euuen.glframework.input.KeyTrigger;
import com.euuen.glframework.input.Listener;
import com.euuen.glframework.math.Vector3f;
import com.euuen.glframework.window.WindowManager;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_REPEAT;
import static com.euuen.glframework.input.Key.*;

public class CameraControl extends Control {
    CameraManager cameraManager;
    WindowManager windowManager;

    Camera camera;
    long window_handle;

    float moveSpeed = 0.1f;
    public CameraControl(CameraManager cameraManager, WindowManager windowManager) {
        this.cameraManager = cameraManager;
        this.windowManager = windowManager;
    }

    @Override
    public void initialize() {
        super.initialize();
        camera = (Camera) controllable;
        window_handle = windowManager.getWindow().getHandle();
    }

    @Override
    public void update() {
        super.update();
        // rotate left
        if (isKeyPressed(window_handle, GLFW_KEY_B)){
            cameraManager.execute(() -> camera.rotate(0.05f, new Vector3f(0, 1, 0)));
        }
        // rotate right
        if (isKeyPressed(window_handle, GLFW_KEY_M)){
            cameraManager.execute(() -> camera.rotate(-0.05f, new Vector3f(0, 1, 0)));
        }
        // rotate up
        if (isKeyPressed(window_handle, GLFW_KEY_H)){
            cameraManager.execute(() -> camera.rotate(-0.05f, camera.left));
        }
        // rotate down
        if (isKeyPressed(window_handle, GLFW_KEY_N)){
            cameraManager.execute(() -> camera.rotate(0.05f, camera.left));
        }
        // move fwd
        if (isKeyPressed(window_handle, GLFW_KEY_W)){
            cameraManager.execute(() -> camera.move(camera.direction.mul(1*moveSpeed)));
        }
        // move back
        if (isKeyPressed(window_handle, GLFW_KEY_S)){
            cameraManager.execute(() -> camera.move(camera.direction.mul(-1*moveSpeed)));
        }
        // move left
        if (isKeyPressed(window_handle,GLFW_KEY_A)){
            cameraManager.execute(() -> camera.move(camera.left.mul(1*moveSpeed)));
        }
        // move right
        if (isKeyPressed(window_handle, GLFW_KEY_D)){
            cameraManager.execute(() -> camera.move(camera.left.mul(-1*moveSpeed)));
        }
        // move up
        if (isKeyPressed(window_handle, GLFW_KEY_SPACE)){
            cameraManager.execute(() -> camera.move(new Vector3f(0, 1*moveSpeed, 0)));
        }
        // move down
        if (isKeyPressed(window_handle, GLFW_KEY_LEFT_CONTROL)){
            cameraManager.execute(() -> camera.move(new Vector3f(0, -1*moveSpeed, 0)));
        }
    }
}














