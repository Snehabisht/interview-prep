/*
    https://leetcode.com/problems/minimum-window-substring/
*/
class Solution {
public:
    // TC : O(N)
    // SC : O(N)
    string minWindow(string s, string t) {
        int n = s.length(), m = t.length();
        if(n<m) return "";
        int minWindowLen = INT_MAX;
        unordered_map<char, int> charFreq;
        for(char &ch : t){
            charFreq[ch]++;
        }
        int i = 0, j = 0;
        int charToFind = charFreq.size();
        int start = 0;
        while(j<m){
            if(charFreq.count(s[j])){
                charFreq[s[j]]--;
                if(charFreq[s[j]] == 0){
                    charToFind--;
                }
            }
            j++;
        }
        if(charToFind == 0) return s.substr(0, m);
        while(j<n){
            if(charFreq.count(s[j])){
                charFreq[s[j]]--;
                if(charFreq[s[j]] == 0){
                    charToFind--;
                }
            }
            while(charToFind == 0){
                int len = j-i+1;
                if(len<minWindowLen){
                    minWindowLen = len;
                    start = i;
                }
                if(charFreq.count(s[i])){
                    charFreq[s[i]]++;
                    if(charFreq[s[i]] == 1){
                        charToFind++;
                    }
                }
                i++;
            }
            j++;
        }
        return minWindowLen == INT_MAX ? "" : s.substr(start, minWindowLen);
    }
};