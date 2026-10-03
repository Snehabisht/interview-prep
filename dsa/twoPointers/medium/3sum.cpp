/*
    https://leetcode.com/problems/3sum/
*/
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int start = 0, n = nums.size();
        vector<vector<int>> res;
        while(start < n-2){
            int left = start+1, right = n-1;
            while(left<right){
                int threeSum = nums[start] + nums[left] + nums[right];
                if(threeSum<0){
                    left++;
                    while(left<right && nums[left]==nums[left-1]) left++;
                } else if(threeSum>0){
                    right--;
                    while(left<right && nums[right]==nums[right+1]) right--;
                } else {
                    res.push_back({nums[start], nums[left], nums[right]});
                    left++;
                    while(left<right && nums[left]==nums[left-1]) left++;
                    right--;
                    while(left<right && nums[right]==nums[right+1]) right--;
                }
            }
            start++;
            while(start<n-2 && nums[start]==nums[start-1]) start++;
        }
        return res;
    }
};