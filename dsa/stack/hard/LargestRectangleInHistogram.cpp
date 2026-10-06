/*
    https://leetcode.com/problems/largest-rectangle-in-histogram/
*/
class Solution {

    vector<int> getNextSmallerIndexToRight(vector<int>& heights, int n){
        stack<int>st;
        vector<int> res(n);
        for(int i = n-1; i>=0; --i){
            while(!st.empty() && heights[st.top()]>=heights[i]){
                st.pop();
            }
            if(st.empty()){
                res[i] = n;
            } else {
                res[i] = st.top();
            }
            st.push(i);
        }
        return res;
    }

    vector<int> getNextSmallerIndexToLeft(vector<int>& heights, int n){
        stack<int>st;
        vector<int> res(n);
        for(int i = 0; i < n; ++i){
            while(!st.empty() && heights[st.top()]>=heights[i]){
                st.pop();
            }
            if(st.empty()){
                res[i] = -1;
            } else {
                res[i] = st.top();
            }
            st.push(i);
        }
        return res;
    }

public:

    // TC : O(3*N)
    // SC : O(2*N)
    // int largestRectangleArea(vector<int>& heights) {
    //     int n = heights.size();
    //     vector<int> nextSmallerIndexToRight =  getNextSmallerIndexToRight(heights, n);
    //     vector<int> nextSmallerIndexToLeft =  getNextSmallerIndexToLeft(heights, n);
    //     int maxArea = 0;
    //     for(int i = 0; i < n; ++i){
    //         maxArea = max(
    //             maxArea,
    //             heights[i]*(nextSmallerIndexToRight[i] - nextSmallerIndexToLeft[i] - 1)
    //         );
    //     }
    //     return maxArea;
    // }

    // TC : O(N)
    // SC : O(N)
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        stack<pair<int,int>> st;
        int res = 0;
        for(int index = 0; index<n; ++index){
            int start = index;
            while(!st.empty() && heights[index]<=st.top().first){
                res = max(res, (index-st.top().second)*st.top().first);
                start = st.top().second;
                st.pop();
            }
            st.push({heights[index], start});
        }
        while(!st.empty()){
            res = max(res, (n-st.top().second)*st.top().first);
            st.pop();
        }
        return res;
    }
};