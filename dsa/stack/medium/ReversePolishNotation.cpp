// TC O(N)
// SC O(N)
class Solution {
    bool isOperator(string &ch){
        return ch=="+" || ch=="-" || ch=="*" || ch =="/";
    }

    int performOperation(int operand1, int operand2, string token){
        int result = 0;
        switch(token[0]){
            case '+' : result = operand2 + operand1;
                       break;
            case '-' : result = operand2 - operand1;
                       break;
            case '*' : result = operand2 * operand1;
                       break;
            default :  result = operand2 / operand1;
                       break;
        }
        return result;
    }

public:
    int evalRPN(vector<string>& tokens) {
        stack<string> operands;
        for(auto &token : tokens){
            if(isOperator(token)){
                int operand1 = stoi(operands.top());
                operands.pop();
                int operand2 = stoi(operands.top());
                operands.pop();
                int result = performOperation(operand1, operand2, token);
                operands.push(to_string(result));
            } else {
                operands.push(token);
            }
        }
        return stoi(operands.top());
    }
};