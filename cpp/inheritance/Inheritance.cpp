#include<iostream>
using namespace std;

class Person {
    public:
    int age;
    string name;

    public:
    Person(int age, string name) {
        this->age = age;
        this->name = name;
        cout<<"Inside base class constructor"<<endl;
    }
};

class Student : public Person {
    int rollNo;
    public:
    Student(int age, string name, int rollNo) : Person(age, name) {
        this->rollNo = rollNo;
        cout<<"Inside derived class constructor"<<endl;
    }

    void getInfo() {
        cout << "name: " << name << endl;
        cout << "age: " << age << endl;
        cout << "rollNo: " << rollNo << endl;
    }
};


int main() {
    Student s1(20, "John", 123);
    s1.getInfo();
    return 0;
}