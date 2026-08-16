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
    shared_ptr<MyClass> sharedPtr = make_shared<MyClass>();
    cout<<" Shared count : "<<sharedPtr.use_count()<<endl; // returns the number of shared_ptr instances managing the same object
    {
        shared_ptr<MyClass> sharedPtr2 = sharedPtr; // shared ownership of the same object 
        cout<<" Shared count : "<<sharedPtr.use_count()<<endl;
    }
    cout<<" Shared count : "<<sharedPtr.use_count()<<endl;
    return 0;
}