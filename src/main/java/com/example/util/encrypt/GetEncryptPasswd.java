package com.example.util.encrypt;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class GetEncryptPasswd {
    public String toEncrypt(String passwd){
        return BCrypt.hashpw(passwd,BCrypt.gensalt());
    }

    public boolean checkPasswd(String passwd, String passwdInSql){
        return BCrypt.checkpw(passwd,passwdInSql);
    }
}
