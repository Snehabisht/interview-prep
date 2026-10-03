/*
    https://leetcode.com/problems/contains-duplicate-ii/
*/
class Solution {
public:
    // TC O(N)
    // SC O(k)
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        int n = nums.size();
        k++;
        int j = 0;
        unordered_map<int,int>distinctSeenCount;
        for( ; j<min(n, k) ; ++j){
            distinctSeenCount[nums[j]]++;
        }
        if(distinctSeenCount.size() < min(n, k)){
            return true;
        }
        for( ; j<n ; j++){
            distinctSeenCount[nums[j]]++;
            distinctSeenCount[nums[j-k]]--;
            if(distinctSeenCount[nums[j-k]] == 0){
                distinctSeenCount.erase(nums[j-k]);
            }
            if(distinctSeenCount.size() < k){
                return true;
            }
        }
        return false;
    }

    // TC O(N)
    // SC O(1)
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        int n = nums.size();
        unordered_map<int,int>lastOcc;
        for(int i =0; i<n; ++i){
            if(lastOcc.count(nums[i])){
                if((i-lastOcc[nums[i]]) <=k ){
                    return true;
                }
            }
            lastOcc[nums[i]] = i;
        }
        return false;
    }
};