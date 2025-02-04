package com.euuen.just;

public class Result<T, E>{
    public static int OK = 0;
    public static int ERR = 1;
    public int resultType;
    public T Ok;
    public E Err;
    public Result<T, E> okOf(T Ok){
        resultType = OK;
        this.Ok = Ok;
        return this;
    }
    
    public Result<T, E> errOf(E Err){
        resultType = ERR;
        this.Err = Err;
        return this;
    }
    
    public T upwrap(){
        if (resultType == ERR){
            System.err.println("Java panicked!" + "\n" + "Error{" + Err + "}");
            System.exit(-1);
        }
        return Ok;
    }

    public T expect(String info){
        if (resultType == ERR){
            System.err.println("Java panicked!" + "\n" + "Error{" + Err + "}" + "\n" + "Info{" + info + "}");
            System.exit(-1);
        }
        return Ok;
    }
}