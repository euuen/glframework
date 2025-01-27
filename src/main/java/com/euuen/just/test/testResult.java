package com.euuen.just.test;

import com.euuen.just.Result;

public class testResult {
    public static void main(String[] args) {
        Result<String ,String> result = new Result<>();
        result.errOf("the fucking file has lost!");
        System.out.println(result.expect("your file is died!"));
    }
}
