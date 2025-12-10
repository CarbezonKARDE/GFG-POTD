class Solution {
public:
    vector<int> findTwoElement(vector<int>& arr) {
        long long n = arr.size();
        long long sumN = n * (n + 1) / 2;
        long long sumSqN = n * (n + 1) * (2*n + 1) / 6;
        long long sum = 0, sumSq = 0;
        for(long long x : arr) {
            sum += x;
            sumSq += (long long)x * x;
        }
        long long diff = sum - sumN;
        long long diffSq = sumSq - sumSqN;
        long long sumRM = diffSq / diff;
        long long R = (diff + sumRM) / 2;
        long long M = sumRM - R;
        return {(int)R, (int)M};
    }
};
