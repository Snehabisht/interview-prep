package com.springboot.web_project.config;

import com.springboot.web_project.interceptor.AuthenticationInterceptor;
import com.springboot.web_project.interceptor.AuthorizationInterceptor;
import com.springboot.web_project.interceptor.LoggingInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {
    public LoggingInterceptor loggingInterceptor;

    public AuthenticationInterceptor authenticationInterceptor;

    public AuthorizationInterceptor authorizationInterceptor;

    public WebConfig(
            LoggingInterceptor loggingInterceptor,
            AuthenticationInterceptor authenticationInterceptor,
            AuthorizationInterceptor authorizationInterceptor

    ) {
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry
                .addInterceptor(loggingInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/login", "/api/public/**")
                .order(1);

        registry
                .addInterceptor(authenticationInterceptor)
                .order(2);

        registry
                .addInterceptor(authorizationInterceptor)
                .order(3);

    }
}
