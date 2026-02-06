class Solution {
  public:
    vector<int> smallestDiff(vector<int>& a, vector<int>& b, vector<int>& c) {
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        sort(c.begin(), c.end());
        int i = 0, j = 0, k = 0;
        int n = a.size();
        int bestDiff = INT_MAX;
        int bestSum = INT_MAX;
        vector<int> ans(3);
        while (i < n && j < n && k < n) {
            int x = a[i];
            int y = b[j];
            int z = c[k];
            int mn = min({x, y, z});
            int mx = max({x, y, z});
            int diff = mx - mn;
            int sum = x + y + z;
            if (diff < bestDiff || (diff == bestDiff && sum < bestSum)) {
                bestDiff = diff;
                bestSum = sum;
                vector<int> temp = {x, y, z};
                sort(temp.rbegin(), temp.rend());
                ans = temp;
            }
            if (mn == x) i++;
            else if (mn == y) j++;
            else k++;
        }
        return ans;
    }
};
