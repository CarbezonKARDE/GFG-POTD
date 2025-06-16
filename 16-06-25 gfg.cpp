class Solution {
public:
    long long getCost(int targetHeight, const vector<int>& heights, const vector<int>& cost) {
        long long totalCost = 0;
        for (int i = 0; i < heights.size(); ++i) {
            totalCost += 1LL * abs(heights[i] - targetHeight) * cost[i];
        }
        return totalCost;
    }
    int minCost(vector<int>& heights, vector<int>& cost) {
        int low = *min_element(heights.begin(), heights.end());
        int high = *max_element(heights.begin(), heights.end());
        long long answer = LLONG_MAX;
        while (low <= high) {
            int mid = (low + high) / 2;
            long long costMid = getCost(mid, heights, cost);
            long long costLeft = getCost(mid - 1, heights, cost);
            long long costRight = getCost(mid + 1, heights, cost);
            answer = min({answer, costMid, costLeft, costRight});
            if (costLeft < costMid) {
                high = mid - 1;
            } else if (costRight < costMid) {
                low = mid + 1;
            } else {
                break;
            }
        }
        return answer;
    }
};
