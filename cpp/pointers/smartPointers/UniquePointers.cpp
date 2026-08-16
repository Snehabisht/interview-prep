#include<iostream>
#include<memory>
using namespace std;

int main() {
    unique_ptr<int> unPtr = make_unique<int>(25);
    //*unPtr = 10; also applicable
    unique_ptr<int> unPtr2 = move(unPtr); // transferring ownership of unique_ptr to another unique_ptr
    if(unPtr==NULL){
        cout<<"unPtr now points to NULL\n";
    }
    unique_ptr<int> unPtr3(new int);
    cout<<*unPtr2<<endl; // dereferencing unique_ptr to get the value
    // cout<<*unPtr<<endl; NULL // dereferencing unique_ptr after ownership has been transferred will result in undefined behavior
    cout<<*unPtr3<<endl;
    return 0;
}