class Solution {
  public:
    vector<int> getMarks(vector<int> &l, vector<int> &r, vector<int> &rank) {
        int n = l.size();
        vector<long long> prefix(n);
        for (int i = 0; i < n; i++) {
            long long len = 1LL * r[i] - l[i] + 1;
            prefix[i] = len + (i ? prefix[i - 1] : 0);
        }
        vector<int> ans;
        for (int k : rank) {
            int idx = lower_bound(prefix.begin(), prefix.end(), (long long)k)
                      - prefix.begin();
            long long previous = (idx == 0 ? 0 : prefix[idx - 1]);
            ans.push_back(l[idx] + (k - previous - 1));
        }
        return ans;
    }
};
