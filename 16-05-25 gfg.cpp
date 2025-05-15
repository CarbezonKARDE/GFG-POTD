class Solution {
public:
    vector<int> findSmallestRange(vector<vector<int>>& arr) {
        int k = arr.size();
        int n = arr[0].size();
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        int maxi = INT_MIN;
        for (int i = 0; i < k; i++) {
            pq.push({arr[i][0], i, 0});
            maxi = max(maxi, arr[i][0]);
        }
        int start = 0, end = INT_MAX;
        while (true) {
            auto top = pq.top();
            pq.pop();
            int mini = top[0];
            if (maxi - mini < end - start) {
                start = mini;
                end = maxi;
            }
            if (top[2] + 1 < arr[top[1]].size()) {
                int nextVal = arr[top[1]][top[2] + 1];
                pq.push({nextVal, top[1], top[2] + 1});
                maxi = max(maxi, nextVal);
            } else {
                break;
            }
        }
        return {start, end};
    }
};
