class Codec {
public:

    // Encodes a list of strings to a single string.
    string encode(vector<string>& strs) {
        string encodedString;
        for(auto &str : strs){
            encodedString+=to_string(str.length())+ "#" + str;
        }
        return encodedString;
    }

    // Decodes a single string to a list of strings.
    vector<string> decode(string s) {
        vector<string> decodedString;
        int i = 0;
        while(i<s.length()){
            string len;
            while(i<s.length() && s[i]!='#'){
                len += s[i];
                i++;
            }
            i++;
            string str = s.substr(i, stoi(len));
            i+=stoi(len);
            decodedString.emplace_back(str);
        }
        return decodedString;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.decode(codec.encode(strs));