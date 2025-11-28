class Solution {
public:
    vector<int> subsetXOR(int n) {
        int X;
        if (n % 4 == 0) X = n;
        else if (n % 4 == 1) X = 1;
        else if (n % 4 == 2) X = n + 1;
        else X = 0;
        if (X == n) {
            vector<int> ans(n);
            for (int i = 1; i <= n; i++) ans[i-1] = i;
            return ans;
        }
        int missing = X ^ n;
        vector<int> ans;
        ans.reserve(n - 1);
        for (int i = 1; i <= n; i++) {
            if (i != missing)
                ans.push_back(i);
        }
        return ans;
    }
};
