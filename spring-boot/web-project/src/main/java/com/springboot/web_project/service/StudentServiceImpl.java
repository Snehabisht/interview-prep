package com.springboot.web_project.service;

import com.springboot.web_project.annotation.TrackExecutionTime;
import com.springboot.web_project.dto.CreateStudentRequestDto;
import com.springboot.web_project.dto.CreateStudentResponseDto;
import com.springboot.web_project.dto.UpdateStudentRequestDto;
import com.springboot.web_project.dto.UpdateStudentResponseDto;
import com.springboot.web_project.entity.Student;
import com.springboot.web_project.exception.exceptions.DuplicateResourceException;
import com.springboot.web_project.exception.exceptions.ResourceNotFoundException;
import com.springboot.web_project.repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.Thread.sleep;

@Component
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto createStudentRequestDto){
        // throw new RuntimeException("exception thrown from target");
        Student student = mapToEntity(createStudentRequestDto);
        if(emailExists(student.getEmail())){
            throw new DuplicateResourceException("Email already exists");
        }
        Student createdStudent = studentRepository.save(student);
        System.out.println("student saved");
        return mapToDto(createdStudent);
    }

    private boolean emailExists(String email) {
        return studentRepository.existsByEmail(email);
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
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "getStudent"
    )
    public CreateStudentResponseDto getStudent(Long id){
        try {
            sleep(3000);
        } catch (InterruptedException e) {}
        Student studentResp = studentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id "+ id + " is not found"));
        CreateStudentResponseDto studentRespDto = mapToDto(studentResp);
        return studentRespDto;
    }

    public List<CreateStudentResponseDto> getAllStudents(){
        List<Student> studentResp = studentRepository.findAll();
        List<CreateStudentResponseDto> createStudentResponseDto = studentResp.stream().map(this::mapToDto).toList();
        return createStudentResponseDto;
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq){
       Student existingStudent = studentRepository
               .findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Student doesnt exist"));
       existingStudent.setName(studentReq.getName());
       existingStudent.setRollNo(studentReq.getRollNo());
       existingStudent.setSubject(studentReq.getSubject());
       existingStudent.setAge(studentReq.getAge());
       existingStudent.setUpdatedAt(LocalDateTime.now());
       Student savedStudent = studentRepository.save(existingStudent);
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

    public void deleteStudent(Long id){
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Student with id " + id + "not found"));
        studentRepository.delete(studentToBeDeleted);
    }

    public void deleteStudentSoftly(Long id){
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Student with id " + id + "not found"));
        studentRepository.save(studentToBeDeleted);
    }



}
