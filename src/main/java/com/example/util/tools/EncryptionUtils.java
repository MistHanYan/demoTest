package com.example.util.tools;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class EncryptionUtils {
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "zy45626652847721"; // 替换为你自己的密钥

    public String encrypt(String plainText) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public boolean checkPasswd(String inputPasswd, String passwdInSql) throws Exception {
        return encrypt(inputPasswd).equals(passwdInSql);
    }

}
