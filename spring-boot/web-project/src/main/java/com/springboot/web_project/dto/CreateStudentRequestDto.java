package com.springboot.web_project.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequestDto {
    @NotBlank(message = "Name cannot be null/empty or blank")
    @Size(min = 2, max = 50, message = "Name must be 2 to 50 characters valid")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Student must be atleast 18 years old")
    private int age;

    @NotNull(message = "Student email cannot be null")
    @Email(message = "Student email must be valid")
    private String email;

    @NotNull(message = "Roll number is required")
    private Integer rollNo;

    @NotBlank(message = "Subject is required")
    private String subject;
}
