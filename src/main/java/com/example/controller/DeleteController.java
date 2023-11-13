package com.example.controller;

import com.example.entity.Account;
import com.example.entity.ElectiveInformation;
import com.example.entity.Result;
import com.example.service.impl.tools.DeleteToData;
import com.example.util.mybatis.DeleteData;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @Resource
    private DeleteToData deleteToData;

    private static final Logger logger = LoggerFactory.getLogger(DeleteToData.class);

    private int code;
    @DeleteMapping("/user/delete/elective")
    private Result deleteElective(@RequestBody ElectiveInformation electiveInformation){
        code = deleteToData.deleteElective(electiveInformation);
        return code > 0
                ? Result.success(code,"Successful delete for elective")
                : Result.error(code,"Error for the elective");
    }

    @DeleteMapping("/user/delete/account")
    private Result deleteUserAccount(@RequestBody Account account) throws Exception {
        logger.debug("Successful go on");
        code = deleteToData.deleteAccount(account);
        return code > 0
                ? Result.success(code,"User Successful delete to account")
                : Result.error(code,"User had a error delete to account");
    }
}
