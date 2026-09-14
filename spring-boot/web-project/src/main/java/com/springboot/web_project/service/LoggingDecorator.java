//package com.springboot.web_project.service;
//
//import com.springboot.web_project.dto.CreateStudentRequestDto;
//import com.springboot.web_project.dto.CreateStudentResponseDto;
//import com.springboot.web_project.dto.UpdateStudentRequestDto;
//import com.springboot.web_project.dto.UpdateStudentResponseDto;
//import com.springboot.web_project.util.LoggingServiceUtil;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
////@Component
//// @Primary
//public class LoggingDecorator implements StudentService{
//
//    private StudentServiceImpl studentServiceImpl;
//
//    public LoggingDecorator(StudentServiceImpl studentServiceImpl) {
//        this.studentServiceImpl = studentServiceImpl;
//    }
//
//    public CreateStudentResponseDto createStudent(CreateStudentRequestDto createStudentRequestDto) {
//        LoggingServiceUtil.logStart("StudentServiceImpl", "createStudent");
//        CreateStudentResponseDto createStudentResponseDto = studentServiceImpl.createStudent(createStudentRequestDto);
//        LoggingServiceUtil.logStart("StudentServiceImpl", "createStudent");
//        return createStudentResponseDto;
//    }
//
//    @Override
//    public CreateStudentResponseDto getStudent(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<CreateStudentResponseDto> getAllStudents() {
//        return List.of();
//    }
//
//    @Override
//    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq) {
//        return null;
//    }
//
//    @Override
//    public void deleteStudent(Long id) {
//
//    }
//
//    @Override
//    public void deleteStudentSoftly(Long id) {
//
//    }
//}
