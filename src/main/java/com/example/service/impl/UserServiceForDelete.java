package com.example.service.impl;

import com.example.entity.Account;
import com.example.service.Delete;
import com.example.util.mybatis.DeleteData;
import com.example.util.mybatis.SelectData;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UserServiceForDelete implements Delete {

    @Autowired
    private DeleteData deleteData;

    @Autowired
    private SelectData selectData;
    @Override
    public int deletedToElectiveInformation(String student_num , String electiveId) {
        return deleteData.deleteElective(student_num,electiveId);
    }

    @Override
    public int deletedToAccount(String student_num) {
        return deleteData.deleteAccount(student_num);
    }

    @Override
    public int deleteToDetailed(String student_num) {
        return deleteData.deleteDetailed(student_num);
    }

    public Account getAccount(Account account){
        return selectData.getAccountByAccount(account.getAccount());
    }
}
