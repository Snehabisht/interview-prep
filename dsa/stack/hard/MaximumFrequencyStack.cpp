/*
    https://leetcode.com/problems/maximum-frequency-stack/
*/

class FreqStack {
    unordered_map<int,int> overallCount;
    stack<pair<int,int>> maxFreqStack;
public:
    FreqStack() {
        
    }
    
    // O(N)
    void push(int val) {
        overallCount[val]++;
        stack<pair<int,int>> largerFreq;
        while(!maxFreqStack.empty() && maxFreqStack.top().second > overallCount[val]){
            largerFreq.push(maxFreqStack.top());
            maxFreqStack.pop();
        }
        maxFreqStack.push({val, overallCount[val]});
        while(!largerFreq.empty()){
            maxFreqStack.push(largerFreq.top());
            largerFreq.pop();
        }

    }
    
    int pop() {
        int val = maxFreqStack.top().first;
        maxFreqStack.pop();
        overallCount[val]--;
        return val;
    }
};
// [5, 7, 5, 7, 4, 5]
// [
//   5,2
//   7,2
//   4,1
// ]
// [ {5,1} , {7, 1}, {4,1}, {5,2}, {7,2}, {5,3}]

/*
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack* obj = new FreqStack();
 * obj->push(val);
 * int param_2 = obj->pop();
 */

class FreqStack {
    unordered_map<int, stack<int>> stacksWithFreq;
    unordered_map<int,int> count;
    int maxFreq = 0;
public:
    FreqStack() {
        
    }
    
    //O(1)
    void push(int val) {
        count[val]++;
        stacksWithFreq[count[val]].push(val);
        maxFreq = max(maxFreq, count[val]);
    }
    
    //O(1)
    int pop() {
        int val = stacksWithFreq[maxFreq].top();
        count[val]--;
        stacksWithFreq[maxFreq].pop();
        if(stacksWithFreq[maxFreq].size() == 0) maxFreq--;
        return val;
    }
};

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack* obj = new FreqStack();
 * obj->push(val);
 * int param_2 = obj->pop();
 */