package com.springboot.web_project.aspect;

import com.springboot.web_project.dto.CreateStudentResponseDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // within pointcut expression
    // @Before("within(com.springboot.web_project.service.StudentService)")
    // using named pointcut
    // @Before("com.springboot.web_project.aspect.ApplicationPointcuts.serviceLayer()")
    public void logBeforeMethod(JoinPoint joinPoint){
        System.out.println("Inside logBeforeMethod");
        // return; //still service method will be called
        // throw new RuntimeException(); //here service method will not be called
        Object[] args = joinPoint.getArgs();
        System.out.println(args); //cannot be modified
        System.out.println("Student is going to be saved");
    }

//    @AfterReturning(
//            value = "execution(com.springboot.web_project.dto.CreateStudentResponseDto com.springboot.web_project.service.StudentServiceImpl.createStudent(com.springboot.web_project.dto.CreateStudentRequestDto))",
//            returning = "result"
//    )
//    public void logAfterMethod(
//            // here result variable name must match with the returning variable value
//            CreateStudentResponseDto result
//    ){
//        System.out.println("Target method returned : "+ result.toString());
//        System.out.println("Returned after saving the student");
//    }

    @AfterReturning(
            value = "execution(com.springboot.web_project.dto.CreateStudentResponseDto com.springboot.web_project.service.StudentServiceImpl.createStudent(com.springboot.web_project.dto.CreateStudentRequestDto))",
            returning = "result"
    )
    public CreateStudentResponseDto logAfterMethod(
            // here result variable name must match with the returning variable value
            CreateStudentResponseDto result
    ){
        System.out.println("Target method returned : "+ result.toString());
        result.setAge(67); // this will be modified - very hcky, bad practice
        CreateStudentResponseDto createStudentResponseDto = result;
        createStudentResponseDto.setAge(100);
        System.out.println("Returned after saving the student");
        return createStudentResponseDto; // this will not be returned
    }

//    @AfterThrowing(
//            value = "execution(* com.springboot.web_project.service.StudentServiceImpl.createStudent(..)))"
//    )
//    public void logAfterThrowingMethod(){
//        System.out.println("Exception thrown from target");
//    }

    @AfterThrowing(
            value = "execution(* com.springboot.web_project.service.StudentServiceImpl.createStudent(..)))",
            throwing = "exception"
    )
    public void logAfterThrowingMethod(Throwable exception){
        System.out.println(exception.getClass().getName());
        System.out.println("Exception thrown from target");
    }

    // @annotation pointcut expression
    @After(
            "@Annotation(jdk.jfr.Timestamp)"
    )
    public void logAfterMethod(){
        System.out.println("logAfterMethod executed");
    }

    @Around(
            value =
                    "execution(* com.springboot.web_project.service.StudentServiceImpl.createStudent(..)))"
    )
    public CreateStudentResponseDto logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before Target executed");
        CreateStudentResponseDto createStudentResponseDto = CreateStudentResponseDto.class.newInstance();
        try {
            createStudentResponseDto = (CreateStudentResponseDto) joinPoint.proceed(); //flow directed to service method
        } catch (Throwable e) {
            System.out.println("Exception came, we aint forwarding that");
        }

        System.out.println("After Target executed");

        return createStudentResponseDto;
    }

}
