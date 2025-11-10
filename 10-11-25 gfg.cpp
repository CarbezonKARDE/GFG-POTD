class Solution {
  public:
    int maxProfit(vector<int>& arr) {
        int n = arr.size();
        if(n == 0) return 0;
        int hold = -arr[0];
        int free = 0;
        int cool = 0;
        for(int i = 1; i < n; i++) {
            int newHold = max(hold, free - arr[i]);
            int newFree = max(free, cool);
            int newCool = hold + arr[i];
            
            hold = newHold;
            free = newFree;
            cool = newCool;
        }
        return max(free, cool);
    }
};
