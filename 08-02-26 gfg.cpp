class Solution {
  public:
    int maxProduct(vector<int> &arr) {
        int n = arr.size();
        int maxEnd = arr[0];
        int minEnd = arr[0];
        int ans = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                swap(maxEnd, minEnd);
            }
            maxEnd = max(arr[i], maxEnd * arr[i]);
            minEnd = min(arr[i], minEnd * arr[i]);
            
            ans = max(ans, maxEnd);
        }
        return ans;
    }
};
