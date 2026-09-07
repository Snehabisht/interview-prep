package com.springboot.web_project.service;

import com.springboot.web_project.entity.Student;
import com.springboot.web_project.repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    private final StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        student.setDeleted(false);
        Student createdStudent = studentRepository.save(student);
        return createdStudent;
    }

    // select * from student where id = id and deleted = false
    public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        return studentResp.orElse(null);
    }

    // select * from student where deleted = false
    public List<Student> getAllStudents(){
        List<Student> studentResp = studentRepository.findByDeletedIsFalse();
        return studentResp;
    }

    public Student updateStudent(Long id, Student studentReq){
       Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
       if(existingStudent.isEmpty()) {
           return null;
       }
       Student studentToSave = existingStudent.get();
       studentToSave.setName(studentReq.getName());
       studentToSave.setEmail(studentReq.getEmail());
       studentToSave.setRollNo(studentReq.getRollNo());
       studentToSave.setSubject(studentReq.getSubject());
       studentToSave.setAge(studentReq.getAge());
       studentToSave.setDeleted(false);
       studentRepository.save(studentToSave);
       return studentToSave;
    }

    // soft delete also should be deleted
    public Boolean deleteStudent(Long id){
        boolean studentResp = studentRepository.existsById(id);
        if(!studentResp) return  false;
        studentRepository.deleteById(id);
        return true;
    }

    public Boolean deleteStudentSoftly(Long id){
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        if(studentResp.isEmpty()) return false;
        Student studentToSave = studentResp.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
    }



}
