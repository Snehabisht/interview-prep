package com.springboot.web_project.controller;

import com.springboot.web_project.dto.CreateStudentRequestDto;
import com.springboot.web_project.dto.CreateStudentResponseDto;
import com.springboot.web_project.dto.UpdateStudentRequestDto;
import com.springboot.web_project.dto.UpdateStudentResponseDto;
import com.springboot.web_project.entity.Student;
import com.springboot.web_project.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/{deptId}")
    public ResponseEntity<CreateStudentResponseDto> createStudent(
            @Valid @RequestBody CreateStudentRequestDto createStudentRequestDto,
            @PathVariable Long deptId
            ){
        CreateStudentResponseDto createdStudent = studentService.createStudent(createStudentRequestDto, deptId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@PathVariable Long id){
        CreateStudentResponseDto studentResp = studentService.getStudent(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);

    }

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudents(){
        List<CreateStudentResponseDto> studentsList = studentService.getAllStudents();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentsList);

    }

    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(
            @PathVariable Long id,
            @RequestBody UpdateStudentRequestDto studentReq
    ){
        UpdateStudentResponseDto studentResp =
                studentService.updateStudent(id, studentReq);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);

    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id) {
        studentService.deleteStudentSoftly(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<String> createStudentByDeptName(
            @RequestBody CreateStudentRequestDto student,
            @RequestParam(name = "departmentName") String departmentName
    ){
        studentService.createStudent(student, departmentName);
        return ResponseEntity.ok().build();
    }

}
