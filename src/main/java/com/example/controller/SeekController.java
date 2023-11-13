package com.example.controller;

import com.example.entity.Account;
import com.example.entity.Detailed;
import com.example.entity.ElectiveInformation;
import com.example.entity.Result;
import com.example.service.impl.tools.ShowToData;
import com.example.token.GetByJWT;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Api(tags = "User controller")
@RestController
//
//@RequestMapping("/api")
public class SeekController {
    @Resource
    private ShowToData showData;

    @Resource
    private GetByJWT getByJWT;

    private static final Logger logger = LoggerFactory.getLogger(SeekController.class);

    //@ApiOperation(value = "Used to LogIn by name and passwd in user")
    @PostMapping("/user/login")
    public Result logIn(@RequestBody Account account) throws Exception {
        Account user = new Account();
        if(account.getStudent_num() != null){
           user = showData.checkAccountByStudentNum(account);
        }else if (account.getAccount() != null){
            user = showData.checkAccountByAccount(account);
        }else if (account.getEmail() != null){
            user = showData.checkAccountByEmail(account);
        }else if (account.getPhone_num() != null){
            user = showData.checkAccountByPhoneNum(account);
        }
        return user != null
                ? Result.success(1,"LogIn successfully",
                user,getByJWT.generateToken(user))
                : Result.error(-1,"LogIn error");
    }

    @PostMapping("/user/detailed")
    public Result getDetailed(@RequestBody Account account){
        logger.debug("input account:{}",account);
        Detailed detailed = showData.getDetailedData(account);
        return  detailed != null
                ? Result.success(1,"These are your detailed information for list",detailed)
                : Result.error(0,"Happened a error");
    }

    @PostMapping("/user/elective")
    public Result getElective(@RequestBody Account account){
        List<ElectiveInformation> electiveInformation = showData.getElectiveData(account);
        return electiveInformation != null
                ? Result.success(1,"These are your elective list",electiveInformation)
                : Result.error(0,"Happened a error");
    }
}
