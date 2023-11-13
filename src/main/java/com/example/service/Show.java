package com.example.service;

import com.example.entity.Account;
import com.example.entity.Detailed;
import com.example.entity.ElectiveInformation;

import java.util.List;

public interface Show {
    Account getAccountByAccount(Account account);


    Account getAccountByEmail(Account account);


    Account getAccountByPhoneNum(Account account);

    Account getAccountByStudentNum(Account account);

    Detailed getDetailedByStudentNum(Account account);

    List<ElectiveInformation> getElectiveInformationByStudentNum(Account account);
}
