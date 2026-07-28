#include<iostream>
using namespace std;

class Parent {
  public : 
  void getInfo() {
    cout<<"parent class\n";
  }  
};

class Child : public Parent {
  public : 
  void getInfo() {
    cout<<"child class\n";
  }  
};

int main() {
  Child c1;
  c1.getInfo(); //parent method is overridden by child method, so child method will be called
  return 0;
}