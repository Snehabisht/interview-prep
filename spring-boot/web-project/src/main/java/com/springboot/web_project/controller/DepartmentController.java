package com.springboot.web_project.controller;

import com.springboot.web_project.entity.Department;
import com.springboot.web_project.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public void createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
    }

    @PostMapping("/withStudent")
    public void createDepartment(
            @RequestBody Department department,
            @RequestParam String studentName
            ){
        departmentService.createDepartment(department, studentName);
    }
}
