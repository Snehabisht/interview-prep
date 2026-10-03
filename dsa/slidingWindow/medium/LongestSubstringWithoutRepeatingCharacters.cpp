/*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/
class Solution {
public:
    // TC O(N)
    // SC O(N)
    int lengthOfLongestSubstring(string s) {
        int i = 0, j = 0;
        unordered_map<char, int> charCount;
        int maxNonRepeatingStringLength = 0;
        while(j<s.length()){
            charCount[s[j]]++;
            // even if can be used
            // while(charCount.size()<(j-i+1)){
            //     charCount[s[i]]--;
            //     if(charCount[s[i]] == 0){
            //         charCount.erase(s[i]);
            //     }
            //     i++;
            // }
            if(charCount.size()<(j-i+1)){
                charCount[s[i]]--;
                if(charCount[s[i]] == 0){
                    charCount.erase(s[i]);
                }
                i++;
            }
            if(charCount.size() == (j-i+1)){
                maxNonRepeatingStringLength = max(
                    maxNonRepeatingStringLength,
                    j-i+1
                );
            }
            j++;
        }
        return maxNonRepeatingStringLength;
    }
};