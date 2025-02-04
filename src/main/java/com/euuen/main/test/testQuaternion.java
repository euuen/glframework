package com.euuen.main.test;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import static java.lang.Math.*;

public class testQuaternion {
    public static void main(String[] args) {
        float x = (float) toRadians(30);
        float y = (float) toRadians(60);
        float z = (float) toRadians(75);
        Quaternionf rotation = new Quaternionf().rotateX(x).rotateY(y).rotateZ(z);
        Matrix4f rotMatrix = new Matrix4f().rotate(rotation);
        System.out.println("one:");
        System.out.println(rotMatrix);

        Quaternionf rotation2 = new Quaternionf().rotationY(y).rotationX(x).rotationZ(z);
        Matrix4f rotMatrix2 = new Matrix4f().rotate(rotation);
        System.out.println("two:");
        System.out.println(rotMatrix2);

        Matrix4f rotMatrix3 = new Matrix4f().rotateX(x).rotateY(y).rotateZ(z);
        System.out.println("three:");
        System.out.println(rotMatrix3);

        Matrix4f rotMatrix4 = new Matrix4f().rotateY(y).rotateX(x).rotateZ(z);
        System.out.println("four:");
        System.out.println(rotMatrix4);

    }
}
