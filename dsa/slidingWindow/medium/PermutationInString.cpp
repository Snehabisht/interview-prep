/*
    https://leetcode.com/problems/permutation-in-string/
*/
class Solution {
public:
    // TC O(N+M)
    // SC O(N)
    bool checkInclusion(string s1, string s2) {
        if(s1.length()>s2.length()) return false;
        unordered_map<char,int> s1CharFreq;
        for(char &ch : s1){
            s1CharFreq[ch]++;
        }
        int charsToBeSearched = s1CharFreq.size();
        int n = s1.length();
        int m = s2.length();
        int i = 0, j = 0;
        for(; j<n ; ++j){
            if(s1CharFreq.count(s2[j])){
                s1CharFreq[s2[j]]--;
                if(s1CharFreq[s2[j]] == 0){
                    charsToBeSearched--;
                }
            }
        }
        if(charsToBeSearched == 0) return true;
        for(; j<m ; ++j){
            if(s1CharFreq.count(s2[j])){
                s1CharFreq[s2[j]]--;
                if(s1CharFreq[s2[j]] == 0){
                    charsToBeSearched--;
                }
            }
            if(s1CharFreq.count(s2[j-n])){
                s1CharFreq[s2[j-n]]++;
                if(s1CharFreq[s2[j-n]] ==1){
                    charsToBeSearched++;
                }
            }
            if(charsToBeSearched == 0) return true;
        }
        return false;
    }

    // TC O(N+M) + O(26)
    // SC O(26)
    bool checkInclusion(string s1, string s2) {
        if(s1.length()>s2.length()) return false;
        vector<int> s1CharFreq(26), s2CharFreq(26);
        for(char &ch : s1){
            s1CharFreq[ch-'a']++;
        }
        int n = s1.length();
        int m = s2.length();
        int i = 0, j = 0;
        for(; j<n ; ++j){
            s2CharFreq[s2[j]-'a']++;
        }
        int matches = 0;
        for(int i = 0; i<26; ++i){
            matches +=  (s1CharFreq[i] == s2CharFreq[i]);
        }
        if(matches == 26) return true;
        for(; j<m ; ++j){
            s2CharFreq[s2[j]-'a']++;
            
            if (s1CharFreq[s2[j]-'a'] == s2CharFreq[s2[j]-'a']) matches++;
            else if (s1CharFreq[s2[j]-'a'] == (s2CharFreq[s2[j]-'a']-1)) matches--;
            
            s2CharFreq[s2[j-n]-'a']--;
            if (s1CharFreq[s2[j-n]-'a'] == s2CharFreq[s2[j-n]-'a']) matches++;
            else if (s1CharFreq[s2[j-n]-'a'] == (s2CharFreq[s2[j-n]-'a']+1)) matches--;

            if(matches == 26) return true;
        }
        return false;
    }
};