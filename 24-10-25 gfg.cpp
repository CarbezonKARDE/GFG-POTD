#include <bits/stdc++.h>
using namespace std;
class Solution {
  public:
    bool isPossible(vector<int>& arr, int k) {
        unordered_map<int, int> count, end;
        for (int num : arr) count[num]++;
        
        for (int num : arr) {
            if (count[num] == 0) continue;
            if (end[num - 1] > 0) {
                end[num - 1]--;
                end[num]++;
                count[num]--;
            }
            else {
                bool canStart = true;
                for (int i = 0; i < k; i++) {
                    if (count[num + i] <= 0) {
                        canStart = false;
                        break;
                    }
                }
                if (!canStart) return false;
                for (int i = 0; i < k; i++) count[num + i]--;
                end[num + k - 1]++;
            }
        }
        return true;
    }
};
