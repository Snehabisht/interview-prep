#include<iostream>
#include<string>
using namespace std;

int getNum() {
    return 5;
}

int sum(int a, int b) {
    return a + b;
}

bool compareStringAscending(string s1, string s2) {
    cout<<"Inside compareStringAscending function"<<endl;
    return s1 < s2;
}

bool compareStringDescending(string s1, string s2) {
    cout<<"Inside compareStringDescending function"<<endl;
    return s1 > s2;
}

void compareStrings(string s1, string s2, bool(*funcpointer)(string, string)){
    if(funcpointer(s1, s2)) {
        cout<<s1<<" is less than "<<s2<<endl;
    } else {
        cout<<s1<<" is greater than "<<s2<<endl;
    }
}



int main() {
    // int (*funcPointer)() = getNum; // function pointer declaration and initialization   
    // cout<<funcPointer()<<endl; // invoking the function using the function pointer
    // int (*sumPointer)(int, int) = sum;
    // cout<<sumPointer(2, 3)<<endl;

    // bool(*funcPointer2)(string, string) = compareStringDescending;
    // compareStrings("sneha", "aman", funcPointer2); //directly passing the function name as an argument
    // funcPointer2 = compareStringAscending; //reassigning the function pointer to another function
    // compareStrings("sneha", "aman", funcPointer2); //directly passing
    // const int &p = 10;
    int* ptr;
    cout<<*ptr<<"\n";
    *ptr = 10;
    return 0;
}