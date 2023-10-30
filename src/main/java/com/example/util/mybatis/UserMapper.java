package com.example.util.mybatis;

import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.logging.Logger;


@Mapper
public interface UserMapper {

    // This is a test to contra of mybatis
    @Select("select * from study_test")
    List<User> userList();

    // Seek passwd by id of user
    @Select("SELECT * FROM study_test WHERE id = #{id}")
    String getPasswdById(int id);

    // Delete user by id
    @Delete("delete from study_test where id = #{id}")
    int deleteUserById(int id);

    // Update name by id
    @Update("UPDATE study_test SET name = #{name} WHERE #{id}")
    void updateNameById(int id, String name);

    // Update passwd by id
    @Update("UPDATE study_test SET passwd = #{passwd} WHERE #{id}")
    void updatePassWdById(int id, String passwd);

    // Insert into user
    @Insert("INSERT INTO study_test (name,passwd) values (#{name},#{passwd})")
    void insertUser(String name, String passwd);
}
