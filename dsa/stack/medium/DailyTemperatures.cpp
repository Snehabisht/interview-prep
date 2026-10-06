/*
    https://leetcode.com/problems/daily-temperatures/
*/
class Solution {
public:
    // TC : O(N)
    // SC : O(N)
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int> res(n,0);
        stack<int> nextGreaterTemperatures;
        for(int i = n-1; i >=0 ; --i){
            while(!nextGreaterTemperatures.empty() && 
                temperatures[i]>= temperatures[nextGreaterTemperatures.top()]){
                nextGreaterTemperatures.pop();
            }
            if(nextGreaterTemperatures.empty()){
                res[i] = 0;
            } else {
                res[i] = nextGreaterTemperatures.top()-i;
            }
            nextGreaterTemperatures.push(i);
        }
        return res;

    }
};