package com.springboot.web_project.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// @Component
public class SpringDemoMvcFilter extends OncePerRequestFilter {
    /*
        Directly we get HttpServletRequest and HttpServletResponse - no typecasting needed
        provided by spring mvc
    */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
//            will call doFilterInternal if filter extends OncePerRequestFilter else normal
//                doFilter will be called
                filterChain.doFilter(
                        request, response
                );
    }

    // This is called internally by doFilterInternal
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String uri = request.getRequestURI();
        return !uri.startsWith("/api/*");
    }
}
