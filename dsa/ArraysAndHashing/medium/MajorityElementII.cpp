class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int res1 = INT_MIN, cnt1 = 0, res2 = INT_MIN, cnt2 = 0;
        for(auto &num : nums){
            if(cnt1 == 0 && num!=res2){
                cnt1 = 1;
                res1 = num;
            } else if (cnt2 == 0 && num!=res1){
                cnt2 = 1;
                res2 = num;
            } else if(num == res1) {
                cnt1++;
            } else if(num == res2){
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0, cnt2=0;
        vector<int>res;
        for(auto &num: nums){
            cnt1+=(num == res1);
            cnt2+=(num == res2);
        }
        if(cnt1>(nums.size()/3)) res.push_back(res1);
        if(cnt2>(nums.size()/3)) res.push_back(res2);
        return res;
    }
};