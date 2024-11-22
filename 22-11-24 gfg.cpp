class Solution {
  public:
        int maximumProfit(vector<int> &prices) {
        int maxProfit =0;
        int minPrice =INT_MAX;
        for(auto price : prices){
            minPrice = min(price, minPrice);
            maxProfit =max(maxProfit,price - minPrice);
        }
        return maxProfit;
    }
};
