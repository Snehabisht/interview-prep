class Solution {
public:
    //  TC - O(NlogN) + O(N)
    //  SC - O(N)
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<pair<int,int>> positionIndex;
        int n = position.size();
        for(int i = 0; i < n; ++i){
            positionIndex.push_back({position[i], i});
        }
        sort(positionIndex.begin(), positionIndex.end());
        stack<pair<int,int>> timeToReachByCarFleet;
        for(int i = n-1; i >= 0; --i){
            int speedIndex = positionIndex[i].second;
            int currentTimeToReachDestinationNr = target - positionIndex[i].first;
            int currentTimeToReachDestinationDr = speed[speedIndex];
            
            if( !(
                !timeToReachByCarFleet.empty() && 
                (
                   (1ll* timeToReachByCarFleet.top().first * currentTimeToReachDestinationDr) >=  
                   (1ll* currentTimeToReachDestinationNr *  timeToReachByCarFleet.top().second)
                )
                )
            ){
                
                timeToReachByCarFleet.push({currentTimeToReachDestinationNr, currentTimeToReachDestinationDr});
            }
            
        }
        return timeToReachByCarFleet.size();
    }
};