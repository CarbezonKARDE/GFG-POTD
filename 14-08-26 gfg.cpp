class Solution {
public:
    bool isPossible(vector<int>& arr, int s, int x) {
        vector<long long> values;
        long long sum = s;
        values.push_back(s);
        for (int a : arr) {
            long long next = sum + a;
            if (next > x)
                break;
            values.push_back(next);
            sum += next;
        }
        long long remaining = x;
        for (int i = values.size() - 1; i >= 0; i--) {
            if (values[i] <= remaining) {
                remaining -= values[i];
                if (remaining == 0)
                    return true;
            }
        }
        return remaining == 0;
    }
};
