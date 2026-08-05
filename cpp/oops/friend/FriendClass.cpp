#include<iostream>
using namespace std;

class EquilateralTriangle{
    float a;
    float circumference;
    float area;

    public:
    void setA(float length) {
        this->a = length;
        this->circumference = 3 * a;
        this->area = (1.73 * a * a)/4;
    }

    friend class Homework; // Declare Homework as a friend class
};

class Homework {
    public:
    void printInfo(EquilateralTriangle &et) {
        cout<<"Circumference: "<<et.circumference<<endl;
        cout<<"Area: "<<et.area<<endl;
    }
};



int main() {
    EquilateralTriangle et;
    et.setA(5);
    Homework hw;
    hw.printInfo(et);
    return 0;
}