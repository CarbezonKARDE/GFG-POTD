#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;
class Solution {
  public:
    vector<int> printKClosest(vector<int> arr, int k, int x) {
        int n = arr.size();
        int pos = lower_bound(arr.begin(), arr.end(), x) - arr.begin();
        int left = pos - 1;
        int right = pos;
        vector<int> result;
        while (k > 0) {
            while (left >= 0 && arr[left] == x) left--;
            while (right < n && arr[right] == x) right++;
            if (left >= 0 && right < n) {
                int distL = abs(arr[left] - x);
                int distR = abs(arr[right] - x);
                if (distL < distR || (distL == distR && arr[left] > arr[right])) {
                    result.push_back(arr[left--]);
                } else {
                    result.push_back(arr[right++]);
                }
            } else if (left >= 0) {
                if (arr[left] != x) result.push_back(arr[left--]);
                else left--;
            } else if (right < n) {
                if (arr[right] != x) result.push_back(arr[right++]);
                else right++;
            } else {
                break; // no more elements to check
            }

            k--;
        }
        return result;
    }
};
