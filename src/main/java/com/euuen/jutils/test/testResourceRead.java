package com.euuen.jutils.test;

import com.euuen.jutils.ResourceLoader;
import java.io.IOException;;

public class testResourceRead {
    public static void main(String[] args) throws IOException {
        String content = ResourceLoader.readAll(new testResourceRead(), "assets/triangle.frag")
                .expect("please check your resource location or path");
        System.out.println(content);
    }
}
