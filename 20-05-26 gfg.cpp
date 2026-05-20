class Solution {
  public:
    bool isProduct(vector<int>& arr, long long target) {
        unordered_set<long long> st;
        for (long long x : arr) {
            if (target == 0) {
                if (x == 0) {
                    if (!st.empty()) return true;
                } else {
                    if (st.count(0)) return true;
                }
            } 
            else {
                if (x != 0 && target % x == 0) {
                    long long need = target / x;
                    
                    if (st.count(need))
                        return true;
                }
            }
            st.insert(x);
        }
        return false;
    }
};
