/*
    https://leetcode.com/problems/longest-repeating-character-replacement/
*/
class Solution {
    int getMaxFreq(vector<int>&freq){
        int maxFreq = 0;
        for(int i = 0; i<26; ++i){
            maxFreq = max(
                maxFreq,
                freq[i]
            );
        }
        return maxFreq;
    }
public:
    // TC O(N*26)
    // SC O(N)
    int characterReplacement(string s, int k) {
        vector<int> freq(26, 0);
        int i = 0, j = 0, n = s.length();
        int longestSubstringWithReplacement = 0;
        while(j<n){
            freq[s[j]-'A']++;
            if(getMaxFreq(freq)<(j-i+1-k)){
                freq[s[i]-'A']--;
                i++;
            }
            if(getMaxFreq(freq)>=(j-i+1-k)){
                longestSubstringWithReplacement = max(
                    longestSubstringWithReplacement,
                    j-i+1
                );
            }
            j++;
        }
        return longestSubstringWithReplacement;
    }

    // TC O(N)
    // SC O(N)
    int characterReplacement(string s, int k) {
        vector<int> freq(26, 0);
        int i = 0, j = 0, n = s.length();
        int maxFreq = 0;
        int longestSubstringWithReplacement = 0;
        while(j<n){
            freq[s[j]-'A']++;
            maxFreq = max(maxFreq,freq[s[j]-'A']);
            while(maxFreq<(j-i+1-k)){
                freq[s[i]-'A']--;
                i++;
            }
            if(maxFreq>=(j-i+1-k)){
                longestSubstringWithReplacement = max(
                    longestSubstringWithReplacement,
                    j-i+1
                );
            }
            j++;
        }
        return longestSubstringWithReplacement;
    }
};