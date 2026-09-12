package com.springboot.web_project.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcuts {

    @Pointcut("within(com.springboot.web_project.controller..*)")
    public void controllerLayer(){
        //empty body
    }

    @Pointcut("within(com.springboot.web_project.service..*)")
    public void serviceLayer(){
        //empty body
    }

    @Pointcut("execution(public * * (..))")
    public void publicMethod(){
        //empty body
    }

    @Pointcut("serviceLayer() && publicMethod()")
    public void publicServiceMethod(){
        //empty body
    }
}
