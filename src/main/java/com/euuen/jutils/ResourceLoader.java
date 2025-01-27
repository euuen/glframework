package com.euuen.jutils;

import com.euuen.just.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.euuen.jutils.LineNumber.*;

public class ResourceLoader {

    // 解释一下，你必须要输入一个你的模块的中的类的示例，这样才能正确定位到你的resources文件夹
    public static Result<String ,String> readAll(Object module, String path){
        Result<String, String> result = new Result<>();
        try (InputStream inputStream = module.getClass().getClassLoader().getResourceAsStream(path)) {
            if (inputStream == null) return result.errOf(String.format("[com.euuen.jutils.ResourceLoader:line %d]:", getCurrentLineNumber()) + "your resources file path : [" + path + "] is wrong");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            while (true){
                String line = reader.readLine();
                if (line == null) break;
                builder.append(line).append("\n");
            }
            return result.okOf(builder.toString());
        } catch (IOException e) {
            return result.errOf(String.format("[com.euuen.jutils.ResourceLoader:line %d]:", getCurrentLineNumber()) + "your resources file path : [" + path + "] is wrong");
        }
    }
}











