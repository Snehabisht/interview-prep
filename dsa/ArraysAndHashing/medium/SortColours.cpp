class Solution {
public:
    // Dutch National Flag Algorithm
    void sortColors(vector<int>& nums) {
        int i, j, k;
        int n = nums.size();
        i = 0;
        j = 0;
        k = n-1;
        while(j<=k){
            if(nums[j] == 0){
                swap(nums[i], nums[j]);
                i++;
                j++;
            } else if(nums[j] == 1){
                j++;
            } else {
                swap(nums[j], nums[k]);
                k--;
            }
        }
    }
};