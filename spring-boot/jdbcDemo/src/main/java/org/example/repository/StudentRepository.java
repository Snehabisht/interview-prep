package org.example.repository;

import org.example.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Student> studentRowMapper = new BeanPropertyRowMapper<>(Student.class);

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void createStudent(Student student) {
        String sql = """
                INSERT INTO students(name, email, age)
                VALUES(?, ?, ?)
                """;

        int rowsAffected = jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getAge()
        );

        if(rowsAffected == 1){
            System.out.println("User created successfully");
        } else {
            System.out.println("creation failed");
        }
    }

    public void updateStudent(Student student, Long id) {
        String sql = """
                UPDATE students
                SET name = ?,
                    email = ?,
                    age = ?
                WHERE id = ?
                """;

        int rowsAffected = jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getAge(),
                id
        );

        if(rowsAffected == 1){
            System.out.println("User updated successfully");
        } else {
            System.out.println("updation failed");
        }
    }

    public void deleteStudent(Long id) {
        String sql = """
                DELETE from students\s
                WHERE ID = ?
               \s""";

        int rowsAffected = jdbcTemplate.update(sql, id);
        if(rowsAffected == 1 ){
            System.out.println("Delete operation successful");
        } else {
            System.out.println("delete operation failed");
        }
    }

    public List<Student> getStudents() {
        String sql = """
                     SELECT id, name, email, age from students
                     """;
        return jdbcTemplate.query(sql, studentRowMapper);
    }

    public Student getsStudentById(Long id) {
        String sql = """
                     SELECT id, name, email, age from students where id = ?
                     """;
        return jdbcTemplate.queryForObject(sql, studentRowMapper, id);
    }
}
