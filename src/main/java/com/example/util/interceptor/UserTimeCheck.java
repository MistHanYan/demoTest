package com.example.util.interceptor;

import com.example.token.GetByJWT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class UserTimeCheck implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UserTimeCheck.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 在处理请求之前执行的操作

        if(request.getRequestURI().contains("signup") || request.getRequestURI().contains("login")){
            return true;
        }else {
            String token = request.getHeader("token");
            if(token != null){
                logger.debug("This is a successful for student to check");
                return new GetByJWT().checkJwtTimed(token);
            }
            response.getWriter().write(-1);
            return false;
        }
    }

    /*public String getStudentNum(BufferedReader bufferedReader) throws IOException {
        return new ObjectMapper().readValue(bufferedReader,Account.class)
                .getStudent_num();
    }*/
}
