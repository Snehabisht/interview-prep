#include<iostream>
using namespace std;

class Parent {
  public : 
  virtual void getInfo() {
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
  Parent* c1 = new Child(); // Upcasting
  c1->getInfo(); // Output: child class
  return 0;
}