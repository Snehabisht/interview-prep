/*
    https://leetcode.com/problems/baseball-game/
*/
class Solution {
public:
    // TC : O(N)
    // SC : O(N)
    int calPoints(vector<string>& operations) {
        stack<int> previousScore;
        for(auto &operation : operations){
            if(operation=="D"){
                int prevScore = previousScore.top();
                previousScore.push(2*prevScore);
            } else if(operation == "C") {
                previousScore.pop();
            } else if(operation == "+"){
                int prevScore1 = previousScore.top();
                previousScore.pop();
                int prevScore2 = previousScore.top();
                previousScore.pop();
                previousScore.push(prevScore2);
                previousScore.push(prevScore1);
                previousScore.push(prevScore1+prevScore2);
            } else{
                previousScore.push(stoi(operation));
            }
        }
        int totalSum = 0;
        while(!previousScore.empty()){
            cout<<previousScore.top()<<"\n";
            totalSum += previousScore.top();
            previousScore.pop();
        }
        return totalSum;
    }

    // TC : O(N)
    // SC : O(N)
    int calPoints(vector<string>& operations) {
        vector<int> previousScore;
        for(auto &operation : operations){
            if(operation=="D"){
                int prevScore = previousScore.back();
                previousScore.push_back(2*prevScore);
            } else if(operation == "C") {
                previousScore.pop_back();
            } else if(operation == "+"){
                int prevScore1 = previousScore.back();
                previousScore.pop_back();
                int prevScore2 = previousScore.back();
                previousScore.pop_back();
                previousScore.push_back(prevScore2);
                previousScore.push_back(prevScore1);
                previousScore.push_back(prevScore1+prevScore2);
            } else{
                previousScore.push_back(stoi(operation));
            }
        }
        int totalSum = 0;
        for(int i =0 ; i<previousScore.size(); ++i){
            totalSum += previousScore[i];
        }
        return totalSum;
    }
};