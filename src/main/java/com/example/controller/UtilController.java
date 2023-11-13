package com.example.controller;

import com.example.entity.Result;
import com.example.service.impl.UserServiceForUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilController {

    @Resource
    private UserServiceForUtil util;
    @GetMapping("/util/city")
    public Result getCity(){
        return Result.success(1,"The are list of city",util.toCity());
    }

    @GetMapping ("/util/nationality")
    public Result getNationality(){
        return Result.success(1,"The are list of nationality",util.toNationality());
    }

    @GetMapping ("/util/institution")
    public Result getInstitution(){
        return Result.success(1,"The are list of institution",util.toInstitution());
    }

    @GetMapping ("/util/elective/list")
    public Result getElectiveList(){
        return Result.success(1,"The are list of elective",util.toElectiveIClass());
    }
}
