package com.springboot.web_project.service;

import com.springboot.web_project.entity.Department;
import com.springboot.web_project.entity.Student;
import com.springboot.web_project.repository.DepartmentRepository;
import com.springboot.web_project.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository, StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createDepartment(Department department){
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(Department department, String studentName){
        departmentRepository.save(department);

        Student student = new Student();
        student.setDepartment(department);
        student.setName(studentName);

        department.getStudents().add(student);

        studentRepository.save(student);
    }
}
