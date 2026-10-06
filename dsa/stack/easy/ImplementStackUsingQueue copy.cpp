/*
    https://leetcode.com/problems/implement-stack-using-queues/
*/
// Using 2 queues
class MyStack {
    queue<int> q, aux;
public:
    MyStack() {
        
    }
    
    // O(N)
    void push(int x) {
        q.push(x);
        int size = q.size();
        for(int i = 0; i< size-1; ++i){
            aux.push(q.front());
            q.pop();
        }
        while(!aux.empty()){
            q.push(aux.front());
            aux.pop();
        }
    }
    
    // O(1)
    int pop() {
        int val = q.front();
        q.pop();
        return val;
    }
    
    //O(1)
    int top() {
        return q.front();
    }
    
    bool empty() {
        return q.empty();
    }
};

// Optimized soln using 1 queue (imp)
class MyStack {
    queue<int> q;
public:
    MyStack() {
        
    }
    
    // O(N)
    void push(int x) {
        q.push(x);
        int size = q.size();
        // inserting all previous element in LIFO style as in stack and adding new element in front as and when it comes 
        for(int i = 0; i<size-1; ++i){
            q.push(q.front());
            q.pop();
        }
    }
    
    // O(1)
    int pop() {
        int val = q.front();
        q.pop();
        return val;
    }
    
    // O(1)
    int top() {
        return q.front();
    }
    
    // O(1)
    bool empty() {
        return q.empty();
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */