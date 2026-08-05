#include<iostream>
#include<memory>
using namespace std;

class MyClass {
    public:
    MyClass() {
        cout<<"Constructor invoked"<<endl;
    }
    ~MyClass() {
        cout<<"Destructor invoked"<<endl;
    }
};

int main() {
    weak_ptr<MyClass> weakPtr;
    {
        shared_ptr<MyClass> sharedPtr = make_shared<MyClass>();
        weakPtr = sharedPtr; // weak_ptr does not increase the reference count
        cout<<" Shared count : "<<sharedPtr.use_count()<<endl; // returns the number of shared_ptr instances managing the same object
    } 
    return 0;
}