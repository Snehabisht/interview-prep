/*
    https://leetcode.com/problems/decode-string/
*/
class Solution {
public:
    string decodeString(string s) {
        stack<char> st;
        for(char &ch : s){
            if(ch!=']'){
                st.push(ch);
            } else {
                string substr = "";
                while(!st.empty() &&  st.top()!='['){
                    substr = st.top() + substr;
                    st.pop();
                }
                st.pop();
                string k = "";
                while(!st.empty() && isdigit(st.top())){
                    k = st.top() + k;
                    st.pop();
                }
                
                int times = stoi(k);
                while(times--){
                    for(char &c : substr){
                        st.push(c);
                    }
                }
            }
        }
        string res;
        while(!st.empty()){
            res = st.top() + res;
            st.pop();
        }
        return res;
    }
};