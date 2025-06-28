#include <vector>
#include <algorithm>
using namespace std;
class Solution {
  public:
    vector<int> countLessEq(vector<int>& a, vector<int>& b) {
        sort(b.begin(), b.end());
        vector<int> result;
        for (int x : a) {
            int count = upper_bound(b.begin(), b.end(), x) - b.begin();
            result.push_back(count);
        }
        return result;
    }
};
