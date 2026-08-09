#include<iostream>
using namespace std;


class String {
    private:
    char* str;
    unsigned int len;


    public:
    //using initialize list to initialize the member variables - not neccessary though
    String() : str(NULL), len(0) {

    }
    
    //parameterized constructor
    String(char*s){
        len = strlen(s);
        this->str = new char[len+1];
        strcpy(this->str, s);
    }

    //copy constructor
    String(const String &s){
        this->len = s.len; 
        this->str = new char[s.len+1];
        strcpy(this->str, s.str);
    }

    unsigned int length() {
        return len;
    }

    // String& operator=(const String &s){
    //     if(this != &s) {
    //        // delete[] this->str; // Free the existing memory to avoid memory leak
    //         char* temp = this->str;
    //         this->len = s.len;
    //         this->str = new char[len+1];
    //         strcpy(this->str, s.str);
    //         delete[] temp; //make sure to delte only when assignment is done
    //     }
    //     return *this;
    // }

    //using CAS Idiom
    String& operator=(String s){
        swap(*this, s);
        return *this;
    }

    void swap(String &s1, String &s2){
        std::swap(s1.str, s2.str); //copied object is passed, shallow copy created, so poiting to same memory/address
        std::swap(s1.len, s2.len);
    }

    friend ostream& operator<<(ostream&, String&);
    friend istream& operator>>(istream&, String&);
    
    //move constructor
    String(String&& str){ //rvalue reference
        this->str = str.str;
        this->len = str.len;
        //setting empty yet valid values in passed argument
        str.str = NULL;
        str.len = 0;
    }

    //move assignment operator
    String& operator=(String&& str){ //rvalue reference
        if(this != &str){
            char* temp = this->str;
            this->str = str.str;
            this->len = str.len;
            //setting emoty yet valid values in passed argument
            str.str = NULL;
            str.len = 0;
            delete[] temp;
        }

        return *this;
    }

    ~String(){
        if(this->str){
            delete[] str;
            this->str = NULL;
            this->len = 0;
        }
    }

};

ostream& operator<<(ostream &COUT, String &s){
        for(int i=0; s.str[i]!='\0'; i++) {
            COUT<<s.str[i];
        }
        COUT<<endl;
        return COUT;
}

istream& operator>>(istream &CIN, String &s){
        for(int i=0; s.str[i]!='\0'; i++) {
            CIN>>s.str[i];
        }
        return CIN;
}

int main() {
    String s1; //default constructor
    String s2 = "abc"; //parameterized constructor
    String s3(s2); //copy constructor
    String s4;
    s4 = s2; //copy assignment operator
    String s5 = s3; //copy constructor
    cout<<s1.length()<<endl; //get length of string
    cout<<s2<<endl; //operator<< overloading
    cin>>s2; //operator>> overloading
    String s = std::move(s2);
    return 0;
}