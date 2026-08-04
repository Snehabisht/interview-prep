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

    friend void printInfo(EquilateralTriangle &et);
};

void printInfo(EquilateralTriangle &et) {
    cout<<"Circumference: "<<et.circumference<<endl;
    cout<<"Area: "<<et.area<<endl;
}

int main() {
    EquilateralTriangle et;
    et.setA(5);
    printInfo(et);
    return 0;
}