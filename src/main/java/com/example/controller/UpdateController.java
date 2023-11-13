package com.example.controller;

import com.example.entity.Account;
import com.example.entity.Detailed;
import com.example.entity.Result;
import com.example.service.impl.tools.UpdateToData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {
    @Resource
    private UpdateToData updateToData;

    private int code;
    @PostMapping("/user/update/account")
    public Result updateAccount(@RequestBody Account account){
        code = updateToData.updateAccountData(account);
        return code > 0
                ? Result.success(code,"Successful update to data")
                : Result.error(code,"Have a error on the update data");
    }

    @PostMapping("/user/update/detailed")
    public Result updateDetailed(@RequestBody Detailed detailed){
        code = updateToData.updateDetailedData(detailed);
        return code > 0
                ? Result.success(code,"Successful addition")
                : Result.error(code,"Failing add");
    }

    @PostMapping("/user/update/account/passwd")
    public Result updatePasswd(@RequestBody Account account) throws Exception {
        return updateToData.updateUserPassWd(account) > 0
                ? Result.success(1,"Successful addition")
                : Result.error(0,"Failing add");
    }
}
