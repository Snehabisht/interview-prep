package com.springboot.web_project.service;

import com.springboot.web_project.dto.CreateStudentRequestDto;
import com.springboot.web_project.dto.CreateStudentResponseDto;
import com.springboot.web_project.dto.UpdateStudentRequestDto;
import com.springboot.web_project.dto.UpdateStudentResponseDto;
import com.springboot.web_project.entity.Student;
import com.springboot.web_project.repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    private final StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto createStudentRequestDto){
        Student student = mapToEntity(createStudentRequestDto);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        Student createdStudent = studentRepository.save(student);
        return mapToDto(createdStudent);
    }

    private CreateStudentResponseDto mapToDto(Student student) {
        CreateStudentResponseDto createStudentResponseDto = new CreateStudentResponseDto();

        createStudentResponseDto.setId(student.getId());
        createStudentResponseDto.setName(student.getName());
        createStudentResponseDto.setAge(student.getAge());
        createStudentResponseDto.setEmail(student.getEmail());
        createStudentResponseDto.setRollNo(student.getRollNo());
        createStudentResponseDto.setSubject(student.getSubject());
        createStudentResponseDto.setMessage("Student created successfully");
        createStudentResponseDto.setCreatedAt(student.getCreatedAt());
        createStudentResponseDto.setUpdatedAt(student.getUpdatedAt());
        return createStudentResponseDto;
    }

    private Student mapToEntity(CreateStudentRequestDto createStudentRequestDto) {
        Student student = new Student();
        student.setName(createStudentRequestDto.getName());
        student.setAge(createStudentRequestDto.getAge());
        student.setEmail(createStudentRequestDto.getEmail());
        student.setRollNo(createStudentRequestDto.getRollNo());
        student.setSubject(createStudentRequestDto.getSubject());

        student.setDeleted(false);
        return student;
    }

    // select * from student where id = id and deleted = false
    public CreateStudentResponseDto getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        CreateStudentResponseDto studentRespDto = mapToDto(studentResp.get());
        return studentRespDto;
    }

    // select * from student where deleted = false
    public List<CreateStudentResponseDto> getAllStudents(){
        List<Student> studentResp = studentRepository.findByDeletedIsFalse();
        List<CreateStudentResponseDto> createStudentResponseDto = studentResp.stream().map(this::mapToDto).toList();
        return createStudentResponseDto;
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq){
       Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
       if(existingStudent.isEmpty()) {
           return null;
       }
       Student studentToSave = existingStudent.get();
       studentToSave.setName(studentReq.getName());
       studentToSave.setRollNo(studentReq.getRollNo());
       studentToSave.setSubject(studentReq.getSubject());
       studentToSave.setAge(studentReq.getAge());
       studentToSave.setDeleted(false);
       studentToSave.setUpdatedAt(LocalDateTime.now());
       Student savedStudent = studentRepository.save(studentToSave);
       return mapToUpdateDto(savedStudent);
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student savedStudent) {
        UpdateStudentResponseDto updateStudentResponseDto = new UpdateStudentResponseDto();

        updateStudentResponseDto.setId(savedStudent.getId());
        updateStudentResponseDto.setName(savedStudent.getName());
        updateStudentResponseDto.setAge(savedStudent.getAge());
        updateStudentResponseDto.setEmail(savedStudent.getEmail());
        updateStudentResponseDto.setRollNo(savedStudent.getRollNo());
        updateStudentResponseDto.setSubject(savedStudent.getSubject());
        updateStudentResponseDto.setMessage("Student updated successfully");
        updateStudentResponseDto.setUpdatedAt(savedStudent.getUpdatedAt());
        return updateStudentResponseDto;
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
