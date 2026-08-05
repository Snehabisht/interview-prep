#include<iostream>
using namespace std;

class Overload {
  public :
  void print(int x) {
    cout<<"int: "<<x<<endl;
  } 
  void print(char ch) {
    cout<<"char: "<<ch<<endl;
  } 

  void print() {
    cout<<"no parameter"<<endl;
  } 
};

int main() {
  Overload o1;
  o1.print(10); //calls print(int x)
  o1.print();    //calls print() with no parameter
  o1.print('A'); //calls print(char ch)
  return 0;
}