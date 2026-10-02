// quick sort implementation
class Solution {
    int partition(int l, int h, vector<int>&nums){
        int pivot = nums[l];
        int i = l+1, j = h;
        while(i<=j){
            while(i<=j && nums[i]<= pivot){
                i++;
            }
            while(i<=j && nums[j]>pivot){
                j--;
            }
            if(i<j){
                swap(nums[i], nums[j]);
            }
        }
        swap(nums[l], nums[j]);
        return j;
    }

    void quickSort(int l, int h, vector<int>&nums){
        if(l>=h) return;
        int partitionIndex = partition(l,h,nums);
        quickSort(l, partitionIndex-1,nums);
        quickSort(partitionIndex+1, h, nums);
    }

public:
    vector<int> sortArray(vector<int>& nums) {
        quickSort(0, nums.size()-1, nums);
        return nums;
    }
};