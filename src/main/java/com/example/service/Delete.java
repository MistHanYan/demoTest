package com.example.service;

public interface Delete {
    int deletedToElectiveInformation(String student_num , String electiveId);

    int deletedToAccount(String student_num);

    int deleteToDetailed(String student_num);
}
