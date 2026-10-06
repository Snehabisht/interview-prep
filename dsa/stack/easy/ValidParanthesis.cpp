class Solution {
    unordered_map<char, char> mappedOpenBracket;
public:
    Solution(){
            mappedOpenBracket[')'] = '(';
            mappedOpenBracket[']'] = '[';
            mappedOpenBracket['}'] = '{';
    }
    
    // TC : O(N)
    // SC : O(N)
    bool isValid(string s) {
        stack<char> openBrackets;
        for(char &ch : s){
            if(!mappedOpenBracket.contains(ch)){
                openBrackets.push(ch);
            } else {
                if(openBrackets.empty() || mappedOpenBracket[ch]!=openBrackets.top()) return false;
                else openBrackets.pop(); 
            }
        }
        return openBrackets.size()==0;
    }
};