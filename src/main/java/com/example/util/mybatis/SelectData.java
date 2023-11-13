package com.example.util.mybatis;

import com.example.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface SelectData {

    @Select("SELECT * FROM account_information WHERE account = #{account}")
    Account getAccountByAccount(String account);

    @Select("SELECT * FROM account_information WHERE student_num = #{student_num}")
    Account getAccountByStudentNum(String student_num);

    @Select("SELECT * FROM account_information WHERE phone_num = #{phone_num}")
    Account getAccountByPhoneNum(String phone_num);

    @Select("SELECT * FROM account_information WHERE email = #{email}")
    Account getAccountByEmail(String email);

    @Select("SELECT * FROM city")
    List<City> getCity();

    @Select("SELECT * FROM detailed_information WHERE student_num = #{student_num}")
    Detailed getDetailedByStudentNum(String student_num);
    @Select("SELECT * FROM elective_class")
    List<ElectiveClass> getElectiveList();

    @Select("SELECT * FROM institution")
    List<Institution> getInstitutions();

    @Select("SELECT * FROM nationality")
    List<Nationality> getNationality();

    @Select("SELECT * FROM elective_information WHERE student_num = #{student_num}")
    List<ElectiveInformation> getElectiveInformation(String student_num);

    @Select("SELECT * FROM elective_information WHERE student_num = #{student_num} AND elective_id = #{elective_id}")
    ElectiveInformation IsEmptyElectiveInformation(String student_num , String elective_id);

    @Select("SELECT * FROM elective_class WHERE elective_id = #{elective_id}")
    ElectiveClass getSurplusForElective(ElectiveClass electiveClass);
}


