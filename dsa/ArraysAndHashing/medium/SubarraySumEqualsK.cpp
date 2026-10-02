class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> prefixSumCount;
        prefixSumCount[0] = 1;
        int sum = 0;
        int res = 0;
        for(auto &num : nums){
            sum+=num;
            if(prefixSumCount.count(sum-k)){
                res+=prefixSumCount[sum-k];
            }
            prefixSumCount[sum]++;
        }
        return res;
    }
};