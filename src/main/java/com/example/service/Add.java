package com.example.service;

import com.example.entity.Account;
import com.example.entity.Detailed;
import com.example.entity.ElectiveInformation;

public interface Add {
    int addAccount(Account account);

    int addElectiveToInformation(ElectiveInformation electiveInformation);

    int addDetailed(Detailed detailed);
}
