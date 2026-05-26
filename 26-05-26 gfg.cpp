class Solution {
  public:
    int minToggle(vector<int>& arr) {
        int n = arr.size();
        vector<int> prefixOnes(n + 1, 0);
        for (int i = 0; i < n; i++) {
            prefixOnes[i + 1] = prefixOnes[i] + (arr[i] == 1);
        }
        int totalZeros = 0;
        for (int x : arr) {
            if (x == 0) totalZeros++;
        }
        int ans = n;
        for (int i = 0; i <= n; i++) {
            int leftOnes = prefixOnes[i];
            int rightZeros = totalZeros - (i - leftOnes);
            ans = min(ans, leftOnes + rightZeros);
        }
        return ans;
    }
};
