package com.springboot.web_project.aspect;

import com.springboot.web_project.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

//    @Around("@annotation(com.springboot.web_project.annotation.TrackExecutionTime)")
//    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        try {
//            return proceedingJoinPoint.proceed();
//        } finally {
//            long endTime = System.currentTimeMillis();
//            long duration = endTime - startTime;
//
//            String methodName = proceedingJoinPoint.getSignature().getName();
//
//            System.out.println("Time taken by "+ methodName + " : "+ duration);
//        }
//    }

    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint,
                                       TrackExecutionTime trackExecutionTime)
            throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            String operation = trackExecutionTime.operation();
            if(operation.isBlank()){
                operation = proceedingJoinPoint.getSignature().getName();

            }
            long warningThreshold = trackExecutionTime.warnAfter();
            if(duration >= warningThreshold){
                    System.out.println("SLOW OPERATION ALERT : " +
                            "Time taken by \"+ operation + \" : \"+ duration"
                            );
            }
            System.out.println("Time taken by "+ operation + " : "+ duration);
        }
    }

}
