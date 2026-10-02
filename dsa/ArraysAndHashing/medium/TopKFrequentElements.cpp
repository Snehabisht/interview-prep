class Solution {
public:
    // Time Complexity: O(nlogn) + O(k) = O(nlogn)
    // Space Complexity: O(n)
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> freq;
        for(auto &num : nums){
            freq[num]++;
        }
        vector<pair<int,int>> freqWithElement;
        for(auto &fre : freq){
            freqWithElement.push_back({fre.second, fre.first});
        }
        sort(freqWithElement.begin(), freqWithElement.end(), greater<pair<int,int>>());
        vector<int>res;
        for(int i = 0; i<k; ++i){
            res.push_back(freqWithElement[i].second);
        }   
        return res;

    }

    // Time Complexity: O(n) 
    // Space Complexity: O(n)
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> freq;
        for(auto &num : nums){
            freq[num]++;
        }
        vector<vector<int>> freqWithElement(1e5+1);
        int maxFreq = 0;
        for(auto &fre : freq){
            freqWithElement[fre.second].push_back(fre.first);
            maxFreq = max(maxFreq, fre.second);
        }
        vector<int>res;
        for(int i = maxFreq; i>=0; --i){
            for(auto &ele : freqWithElement[i]){
                res.push_back(ele);
                if(res.size() == k) return res;
            }
        }   
        return res;

    }
};

