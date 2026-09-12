package com.springboot.web_project.service;

import com.springboot.web_project.dto.CreateStudentRequestDto;
import com.springboot.web_project.dto.CreateStudentResponseDto;
import com.springboot.web_project.dto.UpdateStudentRequestDto;
import com.springboot.web_project.dto.UpdateStudentResponseDto;

import java.util.List;

public interface StudentService {

    CreateStudentResponseDto createStudent(CreateStudentRequestDto createStudentRequestDto);

    CreateStudentResponseDto getStudent(Long id);

    List<CreateStudentResponseDto> getAllStudents();

    UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq);

    void deleteStudent(Long id);

    void deleteStudentSoftly(Long id);

}
