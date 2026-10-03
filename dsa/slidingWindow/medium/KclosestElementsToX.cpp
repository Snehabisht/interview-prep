/*
    https://leetcode.com/problems/find-k-closest-elements/
    https://www.youtube.com/watch?v=2iCR93_SA5c
*/
class Solution {
public:
    // TC O(N) + O(K)
    // SC O(1)
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int diff = 0;
        int j = 0;
        while(j<k){
            diff+=abs(arr[j]-x);
            j++;
        }
        int resDiff = diff;
        int s = 0;
        while(j<arr.size()){
            diff+=abs(arr[j]-x);
            diff-=abs(arr[j-k]-x);
            if(diff<resDiff){
                resDiff = diff;
                s = j-k+1;
            }
            j++;
        }
        return vector<int>(arr.begin()+s, arr.begin()+s+k);
    }

    // TC O(logN) + O(K)
    // SC O(1)
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        int index = lower_bound(arr.begin(), arr.end(), x) - arr.begin();
        if(index == n) index--;
        if(arr[index]!= x){
            int diff1 = ((index-1)>=0) ? x-arr[index-1] : INT_MAX;
            int diff2 = arr[index]-x;
            if(diff1<=diff2) index--;
        }
        vector<int>res;
        res.push_back(arr[index]);
        int i = index-1;
        int j = index+1;
        while(i>=0 || j<n){
            if(res.size() == k) break;
            int diff1 = (i>=0) ? x-arr[i] : INT_MAX;
            int diff2 = (j<n) ? arr[j]-x : INT_MAX;
            if(diff1<=diff2){
                res.push_back(arr[i]);
                i--;
            } else {
                res.push_back(arr[j]);
                j++;
            }
            
        }
        sort(res.begin(), res.end());
        return res;
    }

    // TC O(logN) + O(K)
    // SC O(1)
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        int l = 0;
        int h = n-k;
        while(l<h){
            int mid = (l+h)>>1;
            int windowStart1Val = arr[mid];
            int windowEnd2Val = arr[mid+k]; //in between elements would be same
            if((x-windowStart1Val)<=(windowEnd2Val-x)){
                //discard all windows starting from mid+1
                h = mid;
            } else {
                //discard all windows starting before and till mid
                l = mid+1;
            }
        }
        return vector<int>(arr.begin()+l, arr.begin()+l+k);
    }
    
};