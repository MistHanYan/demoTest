package com.example.token;

import com.example.entity.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;

@Component
@Service
public class GetByJWT {

    private static final String SECRET_KEY = "MistIsZhangYang1MistIsZhangYang1"; // 用于签名的密钥，请根据实际需求进行修改


    private static final Logger logger = LoggerFactory.getLogger(GetByJWT.class);

    public String generateToken(Account account) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 24*3600*1000*15);

        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        // 添加自定义的声明（可选）
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id",account.getId());
        claims.put("account",account.getAccount());
        claims.put("student_num",account.getStudent_num());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public Claims extractSubject(String token) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean checkJwtTimed(String token){
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            logger.debug("Jwt is success for to check time");
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    public Account extractUser(String token) {
        Claims claims = extractSubject(token);

        // 创建User对象并设置id和name
        Account user = new Account();
        user.setId((int) claims.get("id"));
        user.setAccount((String) claims.get("account"));
        user.setStudent_num((String) claims.get("student_num"));
        return user;
    }
}