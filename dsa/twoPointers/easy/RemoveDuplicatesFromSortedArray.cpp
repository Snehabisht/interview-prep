/*
    https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int index = 0;
        for(int i = 0; i<nums.size(); ++i){
            if(nums[i]!=nums[index]){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }
};