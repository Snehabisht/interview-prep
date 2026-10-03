/*
    https://leetcode.com/problems/valid-palindrome-ii/
*/
class Solution {

    bool isSubstringValidPalindrome(string &s, int i, int j){
        int l = i, r = j;
        while(l<r){
            if(s[l]!=s[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

public:
    bool validPalindrome(string s) {
        int i = 0, j = s.length()-1;
        while(i<j){
            if(s[i]!=s[j]){
                return isSubstringValidPalindrome(s, i, j-1) || 
                    isSubstringValidPalindrome(s, i+1, j);
            }
            i++;
            j--;
        }
        return true;
    }
};