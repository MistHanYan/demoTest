package com.example.controller;

import com.example.entity.Result;
import com.example.entity.User;
import com.example.service.AndroidService;
import com.example.token.GetByJWT;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

//@Api(tags = "User controller")
@RestController
//
//@RequestMapping("/api")
public class UserController {
    @Resource
    private AndroidService androidService;

    @Resource
    private GetByJWT getByJWT;

    @ApiOperation(value = "This is a test")
    @GetMapping("/test")
    public Result data(@RequestParam String bool){
        if(bool.equals("on")){
            return Result.success(1,"succeed",androidService.getUser());
        }
        return Result.error(-1,"error");
    }

    @ApiOperation(value = "Used to delete user by id")
    @DeleteMapping("/DeleteUser")
    public Result deleteToUserById(HttpServletRequest request,@RequestBody User user) throws Exception {
        return androidService.deleteUserById(getByJWT.extractUser(request.getHeader("token")).getId(),user) > 0
                ? Result.success(1,"Succeed to Delete",null)
                : Result.error(-1,"Error to delete");
    }

    @ApiOperation(value = "Used to update user by id in token")
    @PostMapping("/UpdatePasswd")
    public Result updatePasswdOfUser(HttpServletRequest request, @RequestBody User user) throws Exception {
        getByJWT.extractUser(request.getHeader("token"));
        return androidService.updatePasswdOfUser(user,user.getInput_passwd()) > 0
                ? Result.success(1,"Succeed to Update Msg of user",null)
                : Result.error(-1,"Error to Update Msg of user");
    }

    @ApiOperation(value = "Used to update name by id in token")
    @PostMapping("/UpdateName")
    public Result updateNameOfUser(@RequestBody User user ,HttpServletRequest request){
        return androidService.updateNameOfUser(getByJWT.extractUser(request.getHeader("token")).getId(),user.getInput_name()) > 0
                ? Result.success(1,"Succeed to Update name of user",null)
                : Result.error(-1,"Error to Update name of user");
    }

    //@ApiOperation(value = "Used to LogIn by name and passwd in user")
    @PostMapping("/LogIn")
    public Result LogIn(@RequestBody User user) throws Exception {
        System.out.println(user.getUser_name());
        return androidService.logIn(user)
                ? Result.success(1,"LogIn successfully", user)
                : Result.error(-1,"LogIn error");
    }

    @ApiOperation(value = "Used to SignIn by name and passwd in user")
    @PostMapping("/SignIn")
    private Result SignIn(@RequestBody User user) throws Exception {
        return androidService.SignIn(user) > 0
        ? Result.success(1,"registered successfully",null)
                : Result.error(-1,"Registered error");
    }
}
