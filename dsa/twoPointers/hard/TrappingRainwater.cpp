/*
    https://leetcode.com/problems/trapping-rain-water/
*/
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int L = 0, R = n-1;
        int maxL = height[L];
        int maxR = height[R];
        int area = 0;
        while(L<R){
            if(maxL<maxR){
                L++;
                maxL = max(maxL, height[L]);
                area +=  maxL - height[L];
            } else {
                R--;
                maxR = max(maxR, height[R]);
                area +=  maxR - height[R];
            }
            cout<<area<<"\n";
        }
        return area;
    }
};