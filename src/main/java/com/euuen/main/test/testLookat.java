package com.euuen.main.test;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public class testLookat {
    public static void main(String[] args) {
        Matrix4f lookat = new Matrix4f().lookAt(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), new Vector3f(0, 1, 0));
        System.out.println(lookat);
    }
}
