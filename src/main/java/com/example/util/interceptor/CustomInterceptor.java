package com.example.util.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在处理请求之前执行的操作
        // 这里可以进行身份验证、日志记录、数据处理等操作
        return true; // 返回 true 表示继续执行后续的拦截器或处理器方法，返回 false 则中断请求处理
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在整个请求处理完成后执行的操作
        // 可以进行一些资源清理或日志记录等操作
    }
}
