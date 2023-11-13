package com.example.service;

import com.example.entity.Account;
import com.example.entity.Detailed;

public interface Update {
    int updateDetailed(Detailed detailed);
    int updateAccount(Account account);
}
