#include<iostream>
using namespace std;

class String {
    private:
    char* m_Data;
    uint64_t m_Size;

    public:

    String() : m_Data(NULL), m_Size(0) {}

    String(const char* string){
        cout<<"creating \n";
        uint64_t len = strlen(string);
        this->m_Data = new char[len+1];
        this->m_Size = len;
        strcpy(this->m_Data, string);
    }

    String(const String& string){
        cout<<"copying \n";
        uint64_t len = strlen(string.m_Data);
        this->m_Data = new char[len+1];
        this->m_Size = len;
        strcpy(this->m_Data, string.m_Data);
    }

    String(String&& string){
        cout<<"moving \n";
        this->m_Data = string.m_Data; //data just moved, no need to copy
        this->m_Size = string.m_Size;
        string.m_Data = NULL;
        string.m_Size = 0;
    }

    String& operator=(String&& string){
        cout<<"move assignment operator \n";
        if(this != &string){
            delete[] this->m_Data; //to prevent memory leak, remove pre existing data from this
            this->m_Data = string.m_Data; //data just moved, no need to copy
            this->m_Size = string.m_Size;
            string.m_Data = NULL;
            string.m_Size = 0;
        }
        
        return *this;
    }



    ~String() {
        cout<<"deleting\n";
        delete m_Data; //NULL deleted, no issues
    }
    
    
};

class Entity {
    private:
    String m_Name;

    public:
    Entity(const String& name) : m_Name(name) {
        /*
            copy constructor invoked
            copying happens here again for copying "name" to "m_Name" 
        */
    }

    //calls the move constructor
    Entity(String &&name): m_Name(move(name)) {
         /*
            move constructor invoked, but have to typcase the name to rvalue using move
        */

    }

};

int main() {
    String s = "abc";
    Entity a = Entity(s);
    Entity entity(move(a));
    Entity entity1("sneha"); //calls create + move constructor
    Entity entity2(move(a)); //fails if we try getting a->data as it has been set to null, in prev move operation

    String string = "Hello";

    String dest = move(string); //move constructor

    dest = move(string); //move assignment operator
    //or dest.operator=(move(string));
    return 0;
}