package com.IRCTC.RailConnect.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ExecutionTimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Intercepting preHandle Request...");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);   // adding startTime att in req (used by postHandle)
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        long startTime = request.getAttribute("startTime") != null ? (long) request.getAttribute("startTime") : 0L;
        System.out.println("Intercepting postHandle Request...");
        System.out.println("[Execution Time] " + request.getRequestURI() + " " +  (System.currentTimeMillis() - startTime) + " ms");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("Intercepting afterCompletion Request...");
    }
}
