package oops;

class StudentCollege {
    String name;
    int age;
    int rollNumber;
    static final String college; //= "JIIT"; works or static block

    StudentCollege(String name, int age, int rollNumber){
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }

    //static block
    static {
        college = "IITG";
    }

}

public class StaticUsage {

    static void main() {
        System.out.println(StudentCollege.college); //IITG
        StudentCollege s1 = new StudentCollege("Sneha", 27, 101);

        System.out.println(StudentCollege.college);

        StudentCollege s2 = new StudentCollege("ABC", 23, 102);
      //  StudentCollege.college = "IIM";
        System.out.println(StudentCollege.college);

    }
}
