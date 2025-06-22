class Solution {
public:
    vector<int> largestSubset(vector<int>& arr) {
        int n = arr.size();
        sort(arr.begin(), arr.end());
        vector<int> dp(n, 1), prev(n, -1);
        int maxLen = 1;
        vector<int> bestSubset;
        for (int i = 0; i < n; ++i) {
            vector<int> currentSubset = {arr[i]};
            for (int j = 0; j < i; ++j) {
                if (arr[i] % arr[j] == 0 && dp[j] + 1 >= dp[i]) {
                    vector<int> candidateSubset;
                    int k = j;
                    while (k != -1) {
                        candidateSubset.push_back(arr[k]);
                        k = prev[k];
                    }
                    reverse(candidateSubset.begin(), candidateSubset.end());
                    candidateSubset.push_back(arr[i]);

                    if (dp[j] + 1 > dp[i] || 
                       (dp[j] + 1 == dp[i] && candidateSubset > currentSubset)) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                        currentSubset = candidateSubset;
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                bestSubset = currentSubset;
            } else if (dp[i] == maxLen) {
                if (currentSubset > bestSubset) {
                    bestSubset = currentSubset;
                }
            }
        }
        if (bestSubset.empty()) {
            return { *min_element(arr.begin(), arr.end()) };
        }
        return bestSubset;
    }
};
