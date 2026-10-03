/*
    https://leetcode.com/problems/rotate-array/
*/
class Solution {
public:
    Uses extra space
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int>aux(n);
        for(int i = 0; i<n; ++i){
            aux[(i+k)%n] = nums[i];
        }
        for(int i = 0; i<n; ++i){
            nums[i] = aux[i];
        }
    }

    //in place reversal
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k = k%n;
        reverse(nums.begin(), nums.end());
        reverse(nums.begin(), nums.begin()+k);
        reverse(nums.begin()+k, nums.end());
    }
};