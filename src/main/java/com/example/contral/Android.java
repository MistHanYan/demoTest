package com.example.contral;

import com.example.entity.Result;
import com.example.service.AndroidService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class Android {
    @Resource
    AndroidService androidService;

    @GetMapping("/test")
    public Result data(@RequestParam String bool){
        System.out.println(bool);
        if(bool.equals("on")){
            return Result.success("succeed",androidService.getUser());
        }
        return Result.error("0");
    }

    @DeleteMapping("/DeleteUser")
    public Result deleteToUserById(@RequestParam int id, String passwd){
        return Result.success("Succeed to Delete",androidService.deleteUserById(id,passwd));
    }

    @PostMapping("/UpdatePasswd")
    public Result updatePasswdOfUser(){
        return Result.success("Succeed to Update Msg of user",androidService.);
    }

    @PostMapping("/UpdateName")
    public Result updateNameOfUser(){
        return Result.success("Succeed to Update Msg of user",androidService.);
    }

    @PostMapping("/LogIn")
    public Result LogIn(){
        return Result.success();
    }

    @PostMapping("/SignIn")
    private Result SignIn(){
        return Result.success("registered successfully",null);
    }
}
