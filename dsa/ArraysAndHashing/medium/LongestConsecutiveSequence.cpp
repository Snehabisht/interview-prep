class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> seen(nums.begin(), nums.end());
        int lcsLen = 0;
        unordered_set<int> vis;
        for(auto &num : nums){
            if(vis.count(num) || seen.count(num-1)) continue;
            int val = num;
            while(seen.count(val)){
                val++;
            }
            lcsLen = max(lcsLen, val-num);
            vis.insert(num);
        }
        return lcsLen;
    }
};