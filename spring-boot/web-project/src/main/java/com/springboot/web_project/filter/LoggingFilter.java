package com.springboot.web_project.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
//@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        long startTime = System.currentTimeMillis();

        System.out.println("Request entered in Logging Filter");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String requestUUID = UUID.randomUUID().toString();
/*      You cannot simply change the body after calling
        chain.doFilter(request, response) using the standard response object.
        By the time chain.doFilter() returns, the servlet or downstream resources
        have already written the data to the stream,
        committed the response, and closed the buff - no error but no change in response*/
        httpServletResponse.setHeader("X-Request-ID", requestUUID);


        System.out.println("Incoming Request : "+
                httpServletRequest.getMethod() + ", "+
                httpServletRequest.getRequestURI()
        );

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            long duration  = System.currentTimeMillis() - startTime;
            System.out.println("Request exiting from Logging Filter");
            System.out.println("Response status : "+
                    httpServletResponse.getStatus()
            );
            System.out.println("Response Time : "+
                    duration
            );
        }
    }
}
