#include<iostream>
using namespace std;

class Shape {
    public:
    virtual void draw() = 0; // pure virtual function
    void display() { // concrete function
        cout<<"displaying shape\n";
    }
};

class Circle : public Shape {

    public : 
    void draw() {
        cout<<"drawing a circle\n";
    }
};

class Rectangle : public Shape {

    public : 
    void draw() {
        cout<<"drawing a rectangle\n";
    }
};

int main() {
   // Shape* c1 = new Rectangle(); we must implement the pure virtual function draw() in Rectangle class otherwise we cannot create an object of Rectangle class
   Shape* c1 = new Circle();
//    c1->draw();
//    c1->display();
   Shape* c2 = new Rectangle();

   Shape* shapes[2] = {c1, c2}; //runtime polymorphism

   for(int i = 0; i < 2; i++) {
       shapes[i]->draw();
   }

   return 0;
}

