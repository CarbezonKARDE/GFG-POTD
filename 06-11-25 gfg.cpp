class Solution {
  public:
    int numberOfWays(int n) {
        if(n <= 2) return n;
        long long prev2 = 1;
        long long prev1 = 2;
        long long curr;
        for(int i = 3; i <= n; i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
};
