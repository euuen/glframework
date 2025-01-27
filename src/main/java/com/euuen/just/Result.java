package com.euuen.just;

enum ResultType{
    Ok, Err
}

public class Result<T, E>{
    ResultType resultType;
    T Ok;
    E Err;
    public Result<T, E> okOf(T Ok){
        resultType = ResultType.Ok;
        this.Ok = Ok;
        return this;
    }
    
    public Result<T, E> errOf(E Err){
        resultType = ResultType.Err;
        this.Err = Err;
        return this;
    }
    
    public T upwrap(){
        if (resultType.equals(ResultType.Err)){
            System.err.println("Java panicked!" + "\n" + "Error{" + Err + "}");
            System.exit(-1);
        }
        return Ok;
    }

    public T expect(String info){
        if (resultType.equals(ResultType.Err)){
            System.err.println("Java panicked!" + "\n" + "Error{" + Err + "}" + "\n" + "Info{" + info + "}");
            System.exit(-1);
        }
        return Ok;
    }
}