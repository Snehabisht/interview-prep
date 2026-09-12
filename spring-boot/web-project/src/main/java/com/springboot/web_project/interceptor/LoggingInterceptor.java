package com.springboot.web_project.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//@Component
public class LoggingInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("Incoming Request-------");

        System.out.println("HTTP Method " + request.getMethod());
        System.out.println("Request URI " + request.getRequestURI());
        System.out.println("Request Parameters " + request.getQueryString());
        System.out.println("Client IP " + request.getRemoteAddr());
        System.out.println("Token Header " + request.getHeader("token"));


        HandlerMethod method = (HandlerMethod) handler;
        if(handler instanceof HandlerMethod handlerMethod){
            String handlerName = method.getBeanType().getName();
            String methodName = method.getMethod().getName();

            System.out.println("PreHandle called");
            System.out.println("Controller "+ handlerName + " called");
            System.out.println("Method "+ methodName +" called");
        }
        return true; //if false then request will not go ahead, return from here only
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle called");
    }

    // same as work after  doFilter()
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion called");
        System.out.println("Response status "+ response.getStatus());
        if(ex != null){
            System.out.println(ex.getMessage());
        } else {

        }
    }
}
