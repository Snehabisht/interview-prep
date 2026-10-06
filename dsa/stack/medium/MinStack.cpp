/*
    https://leetcode.com/problems/min-stack/
    O(1) - Shraddha Khapra - https://www.youtube.com/watch?v=wHDm-N2m2XY 
    Straight forward approach - NC
*/

// TC : O(1)
// Used 2 stacks, 1 was required - SC : O(2*N) 
class MinStack {
    stack<int>s;
    stack<int>minValue;
public:
    MinStack() {
        
    }
    
    void push(int value) {
        s.push(value);
        minValue.empty() 
         ? minValue.push(s.top())
         : minValue.push(min(s.top(), minValue.top()));
        
    }
    
//     void pop() {
//         s.pop();
//         minValue.pop();
//     }
    
//     int top() {
//         return s.top();
//     }
    
//     int getMin() {
//         return minValue.top();
//     }
// };

// TC : O(1)
// Used 1 stack which was required - SC : O(N) 
class MinStack {
    stack<long long>s;
    long long minValue;

public:
    MinStack() {
        
    }
    
    void push(int value) {
        if(s.empty()){
            s.push(value);
            minValue = value;
        } else if (value>=minValue){
            s.push(value);
        } else {
            // updated val, will be less than actual minValue, ie., value
            s.push((long long)2*value - minValue);
            minValue = value;
        }
    }
    
    void pop() {
        if(s.empty()) return;
        if(s.top() < minValue){
            minValue = (long long) (2*minValue - s.top());
        } 
        s.pop();
    }
    
    int top() {
        if(s.empty()) return -1;
        if(s.top() < minValue){
            return minValue;
        } else {
            return s.top();
        }
    }
    
    int getMin() {
        return minValue;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(value);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */