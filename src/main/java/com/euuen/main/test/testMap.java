package com.euuen.main.test;

import java.util.ArrayList;
import java.util.HashMap;

public class testMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("euue", 1);
        System.out.println(map.containsKey("euuen"));
    }
}
