package org.example.controller;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository studentRepository;

    StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentRepository.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentRepository.getsStudentById(id);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.getStudents();
    }

    @PutMapping
    public void updateStudent(
            @PathVariable Long id,
            @RequestBody Student studentReq
    ){
         studentRepository.updateStudent(studentReq, id);
    }

    @DeleteMapping
    public void deleteStudent(@PathVariable Long id){
        studentRepository.deleteStudent(id);
    }

}
