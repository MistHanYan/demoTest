package com.example.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
@Service
public class GetByJWT {

    private static final String SECRET_KEY = "Mist"; // 用于签名的密钥，请根据实际需求进行修改

    public String generateToken(Map<String,Object> claims) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 24*3600*1000);

        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        // 添加自定义的声明（可选）

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
            return true;
        } catch (Exception ex){
            return false;
        }
    }
}