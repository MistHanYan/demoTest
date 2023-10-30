package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Result {
    private Integer Code; // 响应码，1 代表响应成功; 0 代表失败
    private String msg;  // 响应信息 描述字符串
    private Object data; // 返回的数据

    public static Result success(String msg, Object data){
        return new Result(1,msg,data);
    }
    //失败响应
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
