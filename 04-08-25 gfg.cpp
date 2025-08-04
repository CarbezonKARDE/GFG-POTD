class Solution {
  public:
    int maxRectSum(vector<vector<int>> &mat) {
        int n = mat.size();
        int m = mat[0].size();
        int maxSum = INT_MIN;
        for (int top = 0; top < n; ++top) {
            vector<int> temp(m, 0);
            for (int bottom = top; bottom < n; ++bottom) {
                for (int col = 0; col < m; ++col) {
                    temp[col] += mat[bottom][col];
                }
                int currSum = temp[0], maxCurr = temp[0];
                for (int i = 1; i < m; ++i) {
                    currSum = max(temp[i], currSum + temp[i]);
                    maxCurr = max(maxCurr, currSum);
                }
                maxSum = max(maxSum, maxCurr);
            }
        }
        return maxSum;
    }
};
