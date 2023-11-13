package com.example.service;

import com.example.entity.*;

import java.util.List;

public interface Util {
    List<City> toCity();
    List<Institution> toInstitution();
    List<Nationality> toNationality();

    List<ElectiveClass> toElectiveIClass();
}
