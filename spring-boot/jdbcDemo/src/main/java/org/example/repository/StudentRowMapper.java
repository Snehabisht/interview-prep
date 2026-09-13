//package org.example.repository;
//
//import org.example.model.Student;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Component
//public class StudentRowMapper implements RowMapper<Student> {
//
//    @Override
//    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Student student = new Student();
//        student.setId(rs.getLong("id"));
//        student.setAge(rs.getInt("age"));
//        student.setName(rs.getString("name"));
//        student.setEmail(rs.getString("email"));
//        return student;
//    }
//}
