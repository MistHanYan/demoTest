package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Result {
    private Integer Code; // 响应码，1 代表响应成功; 0 代表失败
    private String msg;  // 响应信息 描述字符串
    private Object data; // 返回的数据
    private String token;

    public static Result success(int Code, String msg, Object data,String token){
        return new Result(Code,msg,data,token);
    }

    public static Result success(int code, String msg){
        return new Result(code,msg,null,null);
    }
    public static Result success(int Code, String msg, Object data){
        return new Result(Code,msg,data,null);
    }
    //失败响应
    public static Result error(int Code, String msg){
        return new Result(Code,msg,null,null);
    }
}
