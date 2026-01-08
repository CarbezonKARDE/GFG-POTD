class Solution {
public:
    long long atMost(vector<int>& arr, int k) {
        long long count = 0;
        int left = 0;
        int odd = 0;
        for (int right = 0; right < arr.size(); right++) {
            if (arr[right] % 2 == 1) odd++;
            while (odd > k) {
                if (arr[left] % 2 == 1) odd--;
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
    int countSubarrays(vector<int>& arr, int k) {
        return atMost(arr, k) - atMost(arr, k - 1);
    }
};
