package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StudentComparator{
    String name;
    int rollNo;
    int marks;

    StudentComparator(String name, int rollNo, int marks){
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }
}

class SortByName implements Comparator<StudentComparator> {
    @Override
    public int compare(StudentComparator o1, StudentComparator o2) {
        return o1.name.compareTo(o2.name);
    }
}

class SortByRollNo implements Comparator<StudentComparator> {
    @Override
    public int compare(StudentComparator o1, StudentComparator o2) {
        return o1.rollNo - o2.rollNo;
    }
}

class SortByMarks implements Comparator<StudentComparator> {
    @Override
    public int compare(StudentComparator o1, StudentComparator o2) {
        return o1.marks - o2.marks;
    }
}


public class ComparatorImpl {
    static void main() {
        StudentComparator s1 = new StudentComparator("Aditya", 101, 85);
        StudentComparator s2 = new StudentComparator("Rohit", 103, 89);
        StudentComparator s3 = new StudentComparator("Rohan", 102, 93);
        StudentComparator s4 = new StudentComparator("Sonu", 104, 98);

        Comparator<StudentComparator> c = new SortByMarks();
        Comparator<StudentComparator> c2 = new SortByRollNo();

        List<StudentComparator> students = new ArrayList<>(List.of(s1, s2, s3, s4));

        students.sort((o1, o2) -> o1.name.compareTo(o2.name));

        students.sort(Comparator.comparingInt(s -> s.marks));

        for (StudentComparator student : students){
            System.out.println(student.name+", "+student.marks);
        }

    }
}
