package com.example.util.config;

import com.example.util.interceptor.UserCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //配置类
public class WebConfig implements WebMvcConfigurer {

    private final UserCheck userCheck;
    @Autowired
    public WebConfig(UserCheck userCheck) {
        this.userCheck = userCheck;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userCheck)
                .addPathPatterns("/**");
    }
}

