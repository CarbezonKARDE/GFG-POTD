class Solution {
  public:
    void genSums(int idx, int end, long long sum,
                 vector<int>& arr, vector<long long>& res) {
        if (idx == end) {
            res.push_back(sum);
            return;
        }
        genSums(idx + 1, end, sum, arr, res);
        genSums(idx + 1, end, sum + arr[idx], arr, res);
    }
    int countSubset(vector<int> &arr, int k) {
        int n = arr.size();
        int mid = n / 2;
        vector<long long> left, right;
        genSums(0, mid, 0, arr, left);
        genSums(mid, n, 0, arr, right);
        unordered_map<long long, int> mp;
        for (auto x : right) {
            mp[x]++;
        }
        long long ans = 0;
        for (auto x : left) {
            long long need = k - x;
            if (mp.count(need)) {
                ans += mp[need];
            }
        }
        return (int)ans;
    }
};
