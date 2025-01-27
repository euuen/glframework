package com.euuen.jutils;

public class LineNumber {
    public static int getCurrentLineNumber() {
        return Thread.currentThread().getStackTrace()[2].getLineNumber();
    }
}
