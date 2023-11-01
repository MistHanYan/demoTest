package com.example.util.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionUtilsTest {

    @Test
    void encrypt() throws Exception {
        String passwd = "077617";
        String pass = new EncryptionUtils().encrypt(passwd);
        System.out.println(pass+"\n"+new EncryptionUtils().encrypt(passwd)+","+pass.length());
    }

    @Test
    void checkPasswd() throws Exception {
        String passwd = "123456";
        String a = "YoShy6avAkNNT75oJZpG2A==";
        System.out.println(new EncryptionUtils().checkPasswd(passwd,a));
    }
}