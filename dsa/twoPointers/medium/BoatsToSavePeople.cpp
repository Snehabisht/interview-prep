class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(people.begin(), people.end());
        int i = 0, j = people.size()-1;
        int boats = 0;
        while(i<=j){
            int weightSum = people[i]+people[j];
            boats++;
            if(weightSum<=limit){
                i++;
                j--;
            } else {
                j--;
            }
        }
        return boats;
    }
};