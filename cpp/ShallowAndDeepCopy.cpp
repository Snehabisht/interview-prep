#include<iostream>
using namespace std;

class Student {
    public:
    string name;
    double* cgpaPtr;

    public:
    Student(string name, double cgpa){
        this->name = name;
        cgpaPtr = new double;
        *cgpaPtr = cgpa;
    }

    void getInfo() {
        cout << "Name: " << name << endl;
        cout << "CGPA: " << *cgpaPtr << endl;
    }

    // //shallow copy
    // Student(Student& s) {
    //     name = s.name;
    //     cgpaPtr = s.cgpaPtr; 
    // }

    // deep copy
    Student(Student& s) {
        name = s.name;
        cgpaPtr = new double;
        *cgpaPtr = *(s.cgpaPtr);
    }

    // Destructor to free the allocated memory
    ~Student() {
        delete cgpaPtr;
    }
};

int main() {
    Student s1("John", 3.5);
    s1.getInfo();
    Student s2(s1); 
    s2.name = "Doe";
    *(s2.cgpaPtr) = 4.2;
    s1.getInfo(); //shallow -> 4.2, deep -> 3.5
    s2.getInfo(); 
    return 0;
}