package com.euuen.main.test;

public class testClass {
    public static void main(String[] args) {
        A a = new A("h"){};
        A b = new A("h"){};
        System.out.println(b.getClass());

    }
}

class A{
    public A(String a){

    }
}