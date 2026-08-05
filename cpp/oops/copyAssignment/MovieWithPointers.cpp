#include<iostream>
using namespace std;

class MovieWithPointers {
    string name;
    string genre;
    float rating;
    int actorsCounter;
    string* actors;

    public:
    MovieWithPointers(string name, string genre, float rating) {
        this->name = name;
        this->genre = genre;
        this->rating = rating;
        this->actorsCounter = 0;
        actors = new string[actorsCounter];
    }

    MovieWithPointers() {
        name = "";
        genre = "";
        rating = 0;
    }

    //copy constructor
    MovieWithPointers(const MovieWithPointers &original) {
        cout << "Copy constructor invoked" << endl;
        this->name = original.name;
        this->genre = original.genre;
        this->rating = original.rating;
        this->actorsCounter = original.actorsCounter;
        this->actors = new string[actorsCounter];
        for (int i = 0; i < actorsCounter; i++)
        {
            this->actors[i] = original.actors[i];
        }
        
    }

    //assignment operator
    MovieWithPointers& operator=(const MovieWithPointers &original){
        cout << "Assignment operator invoked" << endl;
        this->name = original.name;
        this->genre = original.genre;
        this->rating = original.rating;
        this->actorsCounter = original.actorsCounter;
        delete[] this->actors; // Free the existing memory to avoid memory leak
        this->actors = new string[actorsCounter];
        for (int i = 0; i < actorsCounter; i++)
        {
            this->actors[i] = original.actors[i];
        }
        return *this;
    }

    void addActor(string actor) {
        string* newActors = new string[actorsCounter + 1];
        for (int i = 0; i < actorsCounter; i++) {
            newActors[i] = actors[i];
        }
        newActors[actorsCounter]  = actor;
        delete[] actors;
        actors = newActors;
        actorsCounter++;
    }

    void printInfo() {
        cout << "Name: " << name << ", Genre: " << genre << ", Rating: " << rating << endl;
        cout << "Actors: " << endl;
        for(int i = 0; i < actorsCounter; i++) {
            cout <<actors[i] << endl;
        }
    }

};

int main() {
    MovieWithPointers m1("Inception", "Sci-Fi", 8.8); // parameterized constructor is invoked
    MovieWithPointers m2("Lion King", "Animation", 8); // parameterized constructor is invoked
    m1.addActor("Leonardo DiCaprio");
    m1.addActor("Joseph Gordon-Levitt");
    m2.addActor("Matthew Broderick");
    MovieWithPointers m3 = m1; // copy constructor is invoked as m3 is being created
    m3.printInfo(); //m1 values are copied to m3
    
    MovieWithPointers m4;
    m4 = m2; // assignment operator is invoked as m4 already exists
    m4.printInfo(); //m2 values are copied to m4
    return 0;
}
