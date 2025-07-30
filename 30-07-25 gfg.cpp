#include <unordered_map>
#include <vector>
using namespace std;
class Solution {
  public:
    int cntSubarrays(vector<int> &arr, int k) {
        unordered_map<int, int> prefixSumCount;
        int count = 0;
        int prefixSum = 0;
        prefixSumCount[0] = 1;
        for (int num : arr) {
            prefixSum += num;
            if (prefixSumCount.find(prefixSum - k) != prefixSumCount.end()) {
                count += prefixSumCount[prefixSum - k];
            }
            prefixSumCount[prefixSum]++;
        }
        return count;
    }
};
