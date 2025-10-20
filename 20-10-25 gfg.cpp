class Solution {
  public:
    vector<int> countBSTs(vector<int>& arr) {
        int n = arr.size();
        vector<int> catalan(7, 0);
        catalan[0] = catalan[1] = 1;
        for (int i = 2; i <= 6; i++) {
            for (int j = 0; j < i; j++)
                catalan[i] += catalan[j] * catalan[i - j - 1];
        }
        vector<int> sorted = arr;
        sort(sorted.begin(), sorted.end());
        vector<int> result;
        for (int x : arr) {
            int idx = lower_bound(sorted.begin(), sorted.end(), x) - sorted.begin();
            int left = idx;
            int right = n - idx - 1;
            result.push_back(catalan[left] * catalan[right]);
        }
        return result;
    }
};
