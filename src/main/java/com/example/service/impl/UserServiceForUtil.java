package com.example.service.impl;

import com.example.entity.*;
import com.example.service.Util;
import com.example.util.mybatis.SelectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceForUtil implements Util {

    @Autowired
    private SelectData selectData;
    @Override
    public List<City> toCity() {
        return selectData.getCity();
    }

    @Override
    public List<Institution> toInstitution() {
        return selectData.getInstitutions();
    }

    @Override
    public List<Nationality> toNationality() {
        return selectData.getNationality();
    }

    @Override
    public List<ElectiveClass> toElectiveIClass() {
        return selectData.getElectiveList();
    }
}

