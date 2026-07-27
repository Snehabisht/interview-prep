#include <iostream>
#include<string>
using namespace std;

class Teacher {
    private:
    double salary;

    public: 
    //properties/attributes
    string name;
    string dept;
    string subject;

    // non parameterized constructor
    Teacher() { //constructor
        
    }

    // parameterized constructor
    Teacher(string n, string d, string s, double sal) { //constructor
        //this pointer, arrow operator
        this->name = n;
        this->dept = d;
        this->subject = s;
        this->salary = sal;
    }

    //custom copy constructor
    Teacher(Teacher &t) { 
        this->name = t.name;
        this->dept = t.dept;
        this->subject = t.subject;
        this->salary = t.salary;
    }

    //methods
    void changeDepartment(string newDept) {
        dept = newDept;
    }

    //setter
    void setSalary(double s) {
        salary = s;
    }

    //getter
    double getSalary() {
        return salary;
    }

    void getInfo() {
        cout << "Name: " << name << endl;
        cout << "Department: " << dept << endl;
        cout << "Subject: " << subject << endl;
        cout << "Salary: " << salary << endl;
    }

};

int main() {
    Teacher t; //object of class Teacher
    Teacher t1("Sneha", "Computer Science", "C++", 50000); //parameterized constructor called

    t1.getInfo();

    //dot operator to access the properties and methods of the class
    t1.name = "Sneha";
    t1.dept = "Computer Science";
    t1.subject = "C++";
    cout<<t1.name<<endl;
    cout<<t1.dept<<endl;
    cout<<t1.subject<<endl;

   // Teacher t2(t1); //default copy constructor invoked

   Teacher t2(t1); //custom copy constructor invoked

   cout << "After copying t1 to t2 using custom copy constructor:" << endl;
   t2.getInfo();

    return 0;
}