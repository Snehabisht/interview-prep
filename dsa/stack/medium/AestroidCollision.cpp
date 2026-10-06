/*
    https://leetcode.com/problems/asteroid-collision/
*/
class Solution {
public:
    // TC : O(N)
    // SC : O(N)
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> saved;
        for(auto &aestroid : asteroids){
            if(saved.empty() || (aestroid > 0)){
                saved.push(aestroid);
            } else {
                int currentSpeed = -1 * aestroid;
                while(!saved.empty() && saved.top() > 0 && saved.top()<currentSpeed){
                    saved.pop();
                } 
                if(!saved.empty()) {
                    if(saved.top() > 0 && saved.top()  == currentSpeed){
                        saved.pop();
                    } else if(saved.top()<0){
                        saved.push(aestroid);
                    }
                } else {
                    saved.push(aestroid);
                }
            }
        }
        vector<int> savedAestroids(saved.size());
        int index = saved.size()-1;
        while(!saved.empty()){
            savedAestroids[index--] = saved.top();
            saved.pop();
        }
        return savedAestroids;
    }

    // NC clean code
    // TC : O(N)
    // SC : O(N)
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> saved;
        for(auto &aestroid : asteroids){
            while(!saved.empty() && aestroid<0 && saved.top()>0){
                int diff = saved.top() + aestroid;
                if(diff>0){
                    aestroid = 0;
                } else if(diff == 0){
                    saved.pop();
                    aestroid = 0;
                } else {
                    saved.pop();
                }
            }
            if(aestroid){
                saved.push(aestroid);
            }
        }
        vector<int> savedAestroids(saved.size());
        int index = saved.size()-1;
        while(!saved.empty()){
            savedAestroids[index--] = saved.top();
            saved.pop();
        }
        return savedAestroids;
    }
};