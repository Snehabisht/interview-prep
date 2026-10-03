/*
https://leetcode.com/problems/first-missing-positive/description/
*/
class Solution {
public:
    // sorting approach 
    // TC : O(NlogN)
    // SC : O(1)
    int firstMissingPositive(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int i = 0;
        while(i<nums.size() && nums[i]<=0){
            i++;
        }
        if(i==nums.size()) return 1;
        int val = 1;
        while(i<nums.size()){
            if(i!=nums.size() && nums[i]!=val) return val;
            while(i<nums.size() && nums[i]==val) {
                i++;
            }
            val++;
        }
        return val;
    }

    // Hashset approach
    // TC : O(N)
    // SC : O(N)
    int firstMissingPositive(vector<int>& nums) {
        unordered_set<int> present(nums.begin(), nums.end());
        for(int pos = 1; pos<=nums.size(); ++pos){
            if(!present.count(pos)){
                return pos;
            }
        }
        return nums.size()+1;
    }

    // Index Negation approach
    // TC : O(N)
    // SC : O(1)
    int firstMissingPositive(vector<int>& nums) {
        for(auto &num : nums){
            if(num<0) num = 0;
        }
        for(int i = 0; i<nums.size(); ++i){
            int val = abs(nums[i]);
            int index = val-1;
            if(index>=0 && index<nums.size()){
                if(nums[index]>0){
                    nums[index] = -1*nums[index];
                } else if(nums[index]==0){
                    nums[index] = -1*(nums.size()+1);
                }
            }
        }

        for(int i = 0; i<nums.size(); ++i){
            if(nums[i]>=0){
                return i+1;
            }
        }
        return nums.size()+1;
    }


};