package com.example.controller;

import com.example.entity.Account;
import com.example.entity.ElectiveClass;
import com.example.entity.Result;
import com.example.service.impl.tools.AddToData;
import com.example.token.GetByJWT;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddController {

    @Resource
    private AddToData addData;

    @Resource
    private GetByJWT getByJWT;

    private int code;

    //private static final Logger logger = LoggerFactory.getLogger(AddController.class);
    @PostMapping("/user/signup")
    public Result signIn(@RequestBody Account account) throws Exception {
        code = addData.addAccountOfUser(account);
        return code > 0
                ? Result.success(code,"Welcome to here")
                : Result.error(code,"Oh~~,No god");
    }

    @PostMapping("/user/add/elective")
    public Result addElective(@RequestBody ElectiveClass electiveClass, HttpServletRequest token){
        code = addData.addElective(electiveClass,getByJWT.extractUser(
                        token.getHeader("token")).getStudent_num());
        return code > 0 ? Result.success(1,"Successful addition")
        :Result.error(code,"Failing add");
    }
}
