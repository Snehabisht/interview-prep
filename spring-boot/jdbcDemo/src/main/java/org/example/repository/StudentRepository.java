package org.example.repository;

import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "Sneha@12";

    public void createUser() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully");

            Statement statement = connection.createStatement();

            String sql = "INSERT INTO students(name, email, age)" +
                    "VALUES('Aditya', 'adi@gmail.com', 28)";

            int result = statement.executeUpdate(sql);
            if(result == 1 ){
                System.out.println("User created successfully");
            } else {
                System.out.println("creation failed");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }

    }

    public void updateUser() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully");

            Statement statement = connection.createStatement();

            String sql = "UPDATE students SET age = 30 " +
                    "WHERE ID = 1";

            int result = statement.executeUpdate(sql);
            if(result == 1 ){
                System.out.println("User updated successfully");
            } else {
                System.out.println("updated failed");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }

    }

    public void deleteUser() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully");

            Statement statement = connection.createStatement();

            String sql = "DELETE from students " +
                    "WHERE ID = 1";

            int result = statement.executeUpdate(sql);
            if(result == 1 ){
                System.out.println("Delete operation successful");
            } else {
                System.out.println("delete operation failed");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }

    }

    public void getUserId() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully");

            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, email, age from students";

            ResultSet resultSet = statement.executeQuery(sql);
            List<Student> students = new ArrayList<>();
            while(resultSet.next()){
                Student student = mapRow(resultSet);
                students.add(student);
            }
            System.out.println(students);

//            if(result == 1 ){
//                System.out.println("Read operation successful");
//            } else {
//                System.out.println("Read operation failed");
//            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }

    }

    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setAge(resultSet.getInt("age"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        return student;
    }
}
