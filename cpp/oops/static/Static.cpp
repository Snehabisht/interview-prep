#include<iostream>
using namespace std;

class ABC {
    public : 
    ABC() {
        cout<<"Inside ABC constructor\n";
    }
    ~ABC() {
        cout<<"Inside ABC destructor\n";
    }
};

int main() {
  {
    ABC obj1; //constructor will be called here
  } //destructor will be called here, when obj1 goes out of scope
  cout<<"End of main function\n";
  /*
    Inside ABC constructor
    Inside ABC destructor
    End of main function
  */

  {
    //static object
    static ABC obj2; //constructor will be called here
  }  //destructor will not be called here, when obj2 goes out of scope, because it is static
     //it will be called at the end of the program, when main function ends
  cout<<"End of main function\n"; 
  /*
    Inside ABC constructor
    End of main function
    Inside ABC destructor
  */
  return 0;

}