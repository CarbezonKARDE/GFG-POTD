#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
  public:
    int totalElements(vector<int> &arr) {
        int left = 0, maxLen = 0;
        unordered_map<int, int> freq;

        for (int right = 0; right < arr.size(); ++right) {
            freq[arr[right]]++;

            while (freq.size() > 2) {
                freq[arr[left]]--;
                if (freq[arr[left]] == 0) {
                    freq.erase(arr[left]);
                }
                left++;
            }

            maxLen = max(maxLen, right - left + 1);
        }

        return maxLen;
    }
};
