class Solution {
public:
    int subarrayRanges(vector<int>& arr) {
        int n = arr.size();
        vector<long long> leftGreater(n), rightGreater(n);
        vector<long long> leftSmaller(n), rightSmaller(n);
        stack<int> st;
        while (!st.empty()) st.pop();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] <= arr[i])
                st.pop();
            leftGreater[i] = st.empty() ? i + 1 : i - st.top();
            st.push(i);
        }
        while (!st.empty()) st.pop();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.top()] < arr[i])
                st.pop();
            rightGreater[i] = st.empty() ? n - i : st.top() - i;
            st.push(i);
        }
        while (!st.empty()) st.pop();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] >= arr[i])
                st.pop();
            leftSmaller[i] = st.empty() ? i + 1 : i - st.top();
            st.push(i);
        }
        while (!st.empty()) st.pop();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.top()] > arr[i])
                st.pop();
            rightSmaller[i] = st.empty() ? n - i : st.top() - i;
            st.push(i);
        }
        long long maxSum = 0, minSum = 0;
        for (int i = 0; i < n; i++) {
            long long maxCount = leftGreater[i] * rightGreater[i];
            long long minCount = leftSmaller[i] * rightSmaller[i];
            maxSum += maxCount * arr[i];
            minSum += minCount * arr[i];
        }
        return (int)(maxSum - minSum);
    }
};
