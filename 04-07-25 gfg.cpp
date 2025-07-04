#include <vector>
#include <unordered_map>
using namespace std;
class Solution {
  public:
    int countAtMostK(vector<int>& arr, int k) {
        int left = 0, right = 0;
        int count = 0;
        unordered_map<int, int> freq;
        for (right = 0; right < arr.size(); ++right) {
            if (freq[arr[right]] == 0) {
                k--;
            }
            freq[arr[right]]++;
            while (k < 0) {
                freq[arr[left]]--;
                if (freq[arr[left]] == 0) {
                    k++;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
};
