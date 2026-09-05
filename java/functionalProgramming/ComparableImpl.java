package functionalProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student>{
    String name;
    int marks;

    Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        if(o.marks != this.marks){
            return this.marks-o.marks;
        } else {
            return this.name.compareTo(o.name);
        }
    }
}

public class ComparableImpl {
    static void main() {
        Student s1 = new Student("Sneha", 95);
        Student s2 = new Student("Aman", 98);
        Student s3 = new Student("Siya", 99);
        Student s4 = new Student("Aarya", 99);

        List<Student> students = new ArrayList<>(List.of(s1, s2, s3, s4));

        Collections.sort(students);

        for (Student student : students){
            System.out.println(student.name+", "+student.marks);
        }


    }
}
