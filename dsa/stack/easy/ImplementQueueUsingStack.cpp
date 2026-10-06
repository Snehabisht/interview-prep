/*
    https://leetcode.com/problems/implement-queue-using-stacks/
*/

// peek and pop takes O(N) TC
class MyQueue {
    stack<int> s, aux;
public:
    MyQueue() {
        
    }
    
    //O(1)
    void push(int x) {
        s.push(x);
    }
    
    // O(N) - always
    int pop() {
        while(!s.empty()){
            aux.push(s.top());
            s.pop();
        }
        int val = aux.top();
        aux.pop();
        while(!aux.empty()){
            s.push(aux.top());
            aux.pop();
        }
        return val;
    }
    
    // O(N) - always
    int peek() {
        while(!s.empty()){
            aux.push(s.top());
            s.pop();
        }
        int val = aux.top();
        while(!aux.empty()){
            s.push(aux.top());
            aux.pop();
        }
        return val;
    }
    
    bool empty() {
        return s.empty();
    }
};

// All operations have O(1) ammortized TC
class MyQueue {
    stack<int> s, aux;
public:
    MyQueue() {
        
    }
    
    //O(1)
    void push(int x) {
        s.push(x);
    }
    
    // O(1) - ammortized
    int pop() {
        if(!aux.empty()){
            int val = aux.top();
            aux.pop();
            return val;
        }
        while(!s.empty()){
            aux.push(s.top());
            s.pop();
        }
        int val = aux.top();
        aux.pop();
        // no need of this, keep values in aux
        // while(!aux.empty()){
        //     s.push(aux.top());
        //     aux.pop();
        // }
        return val;
    }
    
    // O(1) - ammortized
    int peek() {
        if(!aux.empty()){
            return aux.top();
        }
        while(!s.empty()){
            aux.push(s.top());
            s.pop();
        }
        int val = aux.top();
        // no need of this, keep values in aux
        // while(!aux.empty()){
        //     s.push(aux.top());
        //     aux.pop();
        // }
        return val;
    }
    
    bool empty() {
        return s.empty() && aux.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */