package oops;

public class ConstructorChaining {
    public static void main() {
        Student s = new Student("Sneha");
        System.out.println(s.rollNumber);
    }
}

class Student {

    String name;
    int age;
    int rollNumber;
    String college;

    //default constructor
    Student() {

    }

    Student(String name){
        //  this.name = name;
        this(name, 0,0, null);
    }

    Student(String name, int age){
//        this.name = name;
//        this.age = age;
        this(name, age,0, null);
    }

    Student(String name, int age, int rollNumber){
//        this.name = name;
//        this.age = age;
//        this.rollNumber = rollNumber;
        this(name, age,rollNumber, null);
    }

    Student(String name, int age, int rollNumber, String college){
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.college = college;
    }

    void printStudent(String name){
        // this(name); not allowed
        System.out.println("Student "+name +" with rollNumber "+this.rollNumber);
    }
}
