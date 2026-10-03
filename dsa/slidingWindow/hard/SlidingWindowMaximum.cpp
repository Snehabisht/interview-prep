/*
    https://leetcode.com/problems/sliding-window-maximum/
*/
class Solution {
public:
    // TC : O(N)
    // SC : O(k)
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        list<int> maxSeenIndex;
        int i = 0 , j = 0;
        while(j<k){
            while(!maxSeenIndex.empty() && nums[maxSeenIndex.back()]<=nums[j]){
                maxSeenIndex.pop_back();
            }
            maxSeenIndex.push_back(j);
            j++;
        }
        vector<int>res;
        res.push_back(nums[maxSeenIndex.front()]);
        int n = nums.size();
        while(j<n){
            while(!maxSeenIndex.empty() && nums[maxSeenIndex.back()]<=nums[j]){
                maxSeenIndex.pop_back();
            }
            maxSeenIndex.push_back(j);
            if(maxSeenIndex.front() == i) maxSeenIndex.pop_front();
            res.push_back(nums[maxSeenIndex.front()]);
            j++;
            i++;
        }
        return res;
    }
};