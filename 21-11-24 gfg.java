class Solution {
    public int maximumProfit(int prices[]) {
        int result=0;
        int n=prices.length;
        for(int i=0;i<n-1;i++)
        {
            if(prices[i]<prices[i+1])
            {
                result=result+prices[i+1]-prices[i];
            }
        }
        return result;
    }
}
