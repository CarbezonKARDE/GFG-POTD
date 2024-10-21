class Solution {
  public:
    int sameOccurrence(vector<int>& arr, int x, int y) {
      unordered_map<int, int> prefixMap;
        int prefixSum = 0;
        int count = 0;
        prefixMap[0] = 1;
        for (int i = 0; i < arr.size(); ++i) {
            if (arr[i] == x) {
                prefixSum += 1;
            } else if (arr[i] == y) {
                prefixSum -= 1;
            }
            if (prefixMap.find(prefixSum) != prefixMap.end()) {
                count += prefixMap[prefixSum];
            }
            prefixMap[prefixSum]++;
        }
        return count;
    }
};
