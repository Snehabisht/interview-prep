#include<iostream>
using namespace std;

void print(void* ptr, char type) {
    switch(type) {
        case 'i':
            cout << "Integer value: " << *(int*)ptr << endl;
            break;
        case 'f':
            cout << "Float value: " << *(float*)ptr << endl;
            break;
        case 'c':
            cout << "Character value: " << *(char*)ptr << endl;
            break;
        default:
            cout << "Unknown type" << endl;
    }
}

int main(){
    int var = 26;
    void* ptr = &var; // void pointer pointing to integer variable
    cout<<*((int*)ptr)<<endl; // dereferencing void pointer after typecasting to integer pointer
    print(&var, 'i'); // passing address of integer variable and type integer
    char ch = 'A';
    print(&ch, 'c'); // passing address of character variable and type character
    return 0;
}