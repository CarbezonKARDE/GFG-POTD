#include <bits/stdc++.h>
using namespace std;
class Solution {
  public:
    vector<int> longestSubarray(vector<int>& arr, int x) {
        int n = arr.size();
        deque<int> maxd, mind;
        int l = 0, bestL = 0, bestLen = 0;
        for (int r = 0; r < n; r++) {
            while (!maxd.empty() && arr[maxd.back()] < arr[r]) 
                maxd.pop_back();
            maxd.push_back(r);
            while (!mind.empty() && arr[mind.back()] > arr[r]) 
                mind.pop_back();
            mind.push_back(r);
            while (!maxd.empty() && !mind.empty() && arr[maxd.front()] - arr[mind.front()] > x) {
                if (maxd.front() == l) maxd.pop_front();
                if (mind.front() == l) mind.pop_front();
                l++;
            }
            if (r - l + 1 > bestLen) {
                bestLen = r - l + 1;
                bestL = l;
            }
        }
        return vector<int>(arr.begin() + bestL, arr.begin() + bestL + bestLen);
    }
};
