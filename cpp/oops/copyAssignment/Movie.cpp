#include<iostream>
using namespace std;

class Movie {
    string name;
    string genre;
    float rating;

    public:
    Movie(string name, string genre, float rating) {
        this->name = name;
        this->genre = genre;
        this->rating = rating;
    }

    Movie() {
        name = "";
        genre = "";
        rating = 0;
    }

    //copy constructor
    Movie(const Movie &original) {
        cout << "Copy constructor invoked" << endl;
        this->name = original.name;
        this->genre = original.genre;
        this->rating = original.rating;
    }

    //assignment operator
    Movie& operator=(const Movie &original){
        cout << "Assignment operator invoked" << endl;
        this->name = original.name;
        this->genre = original.genre;
        this->rating = original.rating;
        return *this;
    }

    void printInfo() {
        cout << "Name: " << name << ", Genre: " << genre << ", Rating: " << rating << endl;
    }

};

int main() {
    Movie m1("Inception", "Sci-Fi", 8.8); // parameterized constructor is invoked
    Movie m2("Lion King", "Animation", 8); // parameterized constructor is invoked
    Movie m3(m1); // copy constructor is invoked
    m3.printInfo(); //m1 values are copied to m3
    Movie m4;
    m4 = m2; // assignment operator is invoked as m4 already exists
    m4.printInfo(); //m2 values are copied to m4
    Movie m5 = m1; // copy constructor is invoked as m5 is being created
    m5.printInfo(); //m1 values are copied to m5
    m5.operator=(m2); // assignment operator is invoked - overloaded operator function is called explicitly
    m5.printInfo();
    return 0;
}
