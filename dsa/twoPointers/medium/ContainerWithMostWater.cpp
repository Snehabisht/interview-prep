/*
    https://leetcode.com/problems/container-with-most-water/
*/
class Solution {
public:
    // TC : O(N^2)
    // SC : O(1)
    int maxArea(vector<int>& height) {
        int maxArea = 0;
        for(int i = 0; i<height.size(); ++i){
            for(int j = i+1 ; j<height.size(); ++j){
                maxArea = max(
                    maxArea, 
                    (j-i)* min(height[i], height[j])
                );
            }
        }
        return maxArea;
    }

    // TC : O(N)
    // SC : O(1)
    int maxArea(vector<int>& height) {
        int i = 0, j = height.size()-1;
        int maxArea = 0;
        while(i<j){
            if(height[i]<=height[j]){
                maxArea = max(maxArea, height[i]*(j-i));
                i++;
            } else {
                maxArea = max(maxArea, height[j]*(j-i));
                j--;
            }
        }
        return maxArea;
    }
};