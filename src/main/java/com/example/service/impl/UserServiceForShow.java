package com.example.service.impl;

import com.example.entity.Account;
import com.example.entity.Detailed;
import com.example.entity.ElectiveInformation;
import com.example.service.Show;
import com.example.util.mybatis.SelectData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class UserServiceForShow implements Show {

    @Autowired
    private SelectData selectData;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceForShow.class);

    @Override
    public Account getAccountByAccount(Account account) {
        return selectData.getAccountByAccount(account.getAccount());
    }

    @Override
    public Detailed getDetailedByStudentNum(Account account) {
        return selectData.getDetailedByStudentNum(account.getStudent_num());
    }

    @Override
    public List<ElectiveInformation> getElectiveInformationByStudentNum(Account account) {
        return selectData.getElectiveInformation(account.getStudent_num());
    }

    @Override
    public Account getAccountByEmail(Account account) {
        return selectData.getAccountByEmail(account.getEmail());
    }

    @Override
    public Account getAccountByPhoneNum(Account account) {
        logger.debug("input account data : {}",account);
        return selectData.getAccountByPhoneNum(account.getPhone_num());
    }

    @Override
    public Account getAccountByStudentNum(Account account) {
        return selectData.getAccountByStudentNum(account.getStudent_num());
    }
}
