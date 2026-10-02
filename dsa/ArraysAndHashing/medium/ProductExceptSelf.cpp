class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> suffixProduct(n, 1);
        suffixProduct[n-1] = 1;
        for(int i = n-2; i>=0; --i){
            suffixProduct[i] = nums[i+1]*suffixProduct[i+1];
        }
        int prefixProduct = 1;
        vector<int> prodExceptSelf(n, 1);
        for(int i = 0 ; i < n; ++i){
            prodExceptSelf[i] = prefixProduct * suffixProduct[i];
            prefixProduct*=nums[i];
        }
        return prodExceptSelf;
    }

    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> prodExceptSelf(n, 1);
        prodExceptSelf[n-1] = 1;
        for(int i = n-2; i>=0; --i){
            prodExceptSelf[i] = nums[i+1]*prodExceptSelf[i+1];
        }
        int prefixProduct = 1;
        for(int i = 0 ; i < n; ++i){
            prodExceptSelf[i] = prefixProduct * prodExceptSelf[i];
            prefixProduct*=nums[i];
        }
        return prodExceptSelf;
    }
};