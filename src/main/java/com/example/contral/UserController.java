package com.example.contral;

import com.example.entity.Result;
import com.example.entity.User;
import com.example.service.AndroidService;
import com.example.token.GetByJWT;
import com.example.token.Token;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Resource
    AndroidService androidService;

    @GetMapping("/test")
    public Result data(@RequestParam String bool){
        System.out.println(bool);
        if(bool.equals("on")){
            return Result.success(1,"succeed",androidService.getUser());
        }
        return Result.error(-1,"error");
    }

    @DeleteMapping("/DeleteUser")
    public Result deleteToUserById(@RequestBody Token token){
        return androidService.deleteUserById(new GetByJWT().extractUser(token.getJwt())) > 0
                ? Result.success(1,"Succeed to Delete",null)
                : Result.error(-1,"Error to delete");
    }

    @PostMapping("/UpdatePasswd")
    public Result updatePasswdOfUser(@RequestBody Token token){
        return androidService.updatePasswdOfUser(new GetByJWT().extractUser(token.getJwt())) > 0
                ? Result.success(1,"Succeed to Update Msg of user",null)
                : Result.error(-1,"Error to Update Msg of user");
    }

    @PostMapping("/UpdateName")
    public Result updateNameOfUser(@RequestBody Token token){
        return androidService.updateNameOfUser(new GetByJWT().extractUser(token.getJwt())) > 0
                ? Result.success(1,"Succeed to Update name of user",
                androidService.getUserById(new GetByJWT().extractUser(token.getJwt())))
                : Result.error(-1,"Error to Update name of user");
    }

    @PostMapping("/LogIn")
    public Result LogIn(@RequestBody User user){

        return androidService.logIn(user) != null
                ? Result.success(1,"LogIn successfully", user)
                : Result.error(-1,"LogIn error");
    }

    @PostMapping("/SignIn")
    private Result SignIn(@RequestBody User user){
        return androidService.SignIn(user) > 0
        ? Result.success(1,"registered successfully",null)
                : Result.error(-1,"Registered error");
    }
}