package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int id;
    private String account;
    private String passwd;
    private String newPasswd;
    private String nickname;
    private String phone_num;
    private String email;
    private String student_num;
}
