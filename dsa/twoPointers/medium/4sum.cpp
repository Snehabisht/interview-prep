/*
    https://leetcode.com/problems/4sum/
*/
class Solution {

    void kSum(vector<int>&nums, int start, int k, long long target, vector<int>&quad, vector<vector<int>>&res){
        if(k==2){
            int left = start;
            int right = nums.size()-1;
            while(left<right){
                int sum = nums[left] + nums[right];
                if(sum<target){
                    left++;
                    while(left<right && nums[left]==nums[left-1]) left++;
                } else if(sum>target){
                    right--;
                    while(left<right && nums[right]==nums[right+1]) right--;
                } else {
                    quad.push_back(nums[left]);
                    quad.push_back(nums[right]);
                    res.push_back(quad);
                    quad.pop_back();
                    quad.pop_back();
                    left++;
                    while(left<right && nums[left]==nums[left-1]) left++;
                    right--;
                    while(left<right && nums[right]==nums[right+1]) right--;
                }
            }
            return;
        }
        while(start<(nums.size()-k+1)){
            quad.push_back(nums[start]);
            kSum(nums, start+1, k-1, target-nums[start], quad, res);
            quad.pop_back();
            start++;
            while((start<(nums.size()-k+1)) && (nums[start] == nums[start-1])) start++;
        }
    }

public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int start1 = 0, start2 = 1, n = nums.size();
        vector<vector<int>> res;
        while(start1<n-3){
            start2 = start1+1;
            while(start2 < n-2){
                int left = start2+1, right = n-1;
                while(left<right){
                    long long fourSum = (long long) nums[start1] + nums[start2]+ nums[left] + nums[right];
                    if(fourSum<target){
                        left++;
                        while(left<right && nums[left]==nums[left-1]) left++;
                    } else if(fourSum>target){
                        right--;
                        while(left<right && nums[right]==nums[right+1]) right--;
                    } else {
                        res.push_back({nums[start1], nums[start2], nums[left], nums[right]});
                        left++;
                        while(left<right && nums[left]==nums[left-1]) left++;
                        right--;
                        while(left<right && nums[right]==nums[right+1]) right--;
                    }
                }
                start2++;
                while(start2<n-2 && nums[start2]==nums[start2-1]) start2++;
            }
            start1++;
            while(start1<n-3 && nums[start1]==nums[start1-1]) start1++;
        }
        return res;
    }

    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        vector<int> quad;
        int k = 4;
        if(nums.size()<k) return {};
        kSum(nums, 0, k, target, quad, res);
        return res;
    }
};