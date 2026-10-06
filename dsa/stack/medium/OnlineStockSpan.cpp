class StockSpanner {
    stack<pair<int,int>> previousGreaterValueAndSpan;
public:
    StockSpanner() {
    }
    
    // TC : O(N) - Ammortized cost 
    int next(int price) {
        int span = 1;
        while(!previousGreaterValueAndSpan.empty() && previousGreaterValueAndSpan.top().first<=price){
            span+=previousGreaterValueAndSpan.top().second;
            previousGreaterValueAndSpan.pop();
        }
        previousGreaterValueAndSpan.push({price, span});
        return span;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */