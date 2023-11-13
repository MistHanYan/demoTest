package com.example.util.mybatis;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteData {
    @Delete("DELETE FROM elective_information WHERE student_num = #{student_num} AND elective_id = #{elective_id}")
    int deleteElective(String student_num , String elective_id);

    @Delete("DELETE FROM account_information WHERE student_num = #{student_num}")
    int deleteAccount(String student_num);

    @Delete("DELETE FROM detailed_information WHERE student_num = #{stuhent_num}")
    int deleteDetailed(String student_num);
}
