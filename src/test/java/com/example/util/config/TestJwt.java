package com.example.util.config;

import com.example.entity.ElectiveClass;
import com.example.token.GetByJWT;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

public class TestJwt {
    @Test
    void testJwt(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6Miwic3R1ZGVudF9udW0iOiIyMDIxNDA4MiIsImFjY291bnQiOiIwOGNkZDUzZDBkIiwiaWF0IjoxNjk5Nzk2MjE0LCJleHAiOjE2OTk4ODI2MTR9.1qF-iVGMDIDZ9J1q3k93Ktc3ysopn4xnRyFpOEzr_QI";
        System.out.println(new GetByJWT().extractUser(token));
        System.out.println(new ElectiveClass());
    }
}
