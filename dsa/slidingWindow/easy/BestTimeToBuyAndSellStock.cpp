class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0, min_price = INT_MAX;
        for(int i = 0; i<prices.size(); ++i){
            min_price = min(min_price, prices[i]);
            int curr_profit = prices[i]-min_price;
            profit = max(curr_profit, profit);
        }
        return profit;
    }
};