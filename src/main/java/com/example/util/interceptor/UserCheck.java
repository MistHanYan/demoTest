package com.example.util.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.example.token.GetByJWT;


@Component
public class UserCheck implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 在处理请求之前执行的操作

        if(request.getRequestURI().contains("SignIn")
                || request.getRequestURI().contains("LogIn")
                || request.getRequestURI().contains("test")){
            return true;
        }else {
            if(request.getHeader("token") != null){
                return new GetByJWT().checkJwtTimed(request.getHeader("token"));
            }
            response.getWriter().write(-1);
            return false;
        }
    }
}
