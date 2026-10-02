class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> anagrams;
        for(auto &str: strs){
            string s = str;
            sort(str.begin(), str.end());
            anagrams[str].push_back(s);
        }
        vector<vector<string>> res;
        for(auto &strings : anagrams){
            res.push_back(strings.second);
        }
        return res;
    }
};

class Solution {
    string getCharCountString(string str){
        vector<int> freq(26, 0);
        for(char &ch : str){
            freq[ch-'a']++;
        }
        string charCountString = "";
        for(int i = 0; i<26; ++i){
            charCountString += to_string(freq[i]) + ",";
        }
        return charCountString;
    }
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> anagrams;
        for(auto &str: strs){
            anagrams[getCharCountString(str)].push_back(str);
        }
        vector<vector<string>> res;
        for(auto &strings : anagrams){
            res.push_back(strings.second);
        }
        return res;
    }
};