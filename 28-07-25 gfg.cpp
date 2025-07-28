class Solution {
public:
    int balanceSums(vector<vector<int>>& mat) {
        int n = mat.size();
        vector<int> rowSum(n, 0), colSum(n, 0);
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        int maxSum = 0;
        for (int i = 0; i < n; ++i)
            maxSum = max({maxSum, rowSum[i], colSum[i]});
        int operations = 0;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                int increment = min(maxSum - rowSum[i], maxSum - colSum[j]);
                mat[i][j] += increment;
                rowSum[i] += increment;
                colSum[j] += increment;
                operations += increment;
            }
        return operations;
    }
};
