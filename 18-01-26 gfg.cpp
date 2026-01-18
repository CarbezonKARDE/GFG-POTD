class Solution {
  public:
    vector<int> nextFreqGreater(vector<int>& arr) {
        int n = arr.size();
        unordered_map<int, int> freq;
        for (int x : arr) {
            freq[x]++;
        }
        vector<int> ans(n, -1);
        stack<int> st;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && freq[st.top()] <= freq[arr[i]]) {
                st.pop();
            }
            if (!st.empty()) {
                ans[i] = st.top();
            }
            st.push(arr[i]);
        }
        return ans;
    }
};
