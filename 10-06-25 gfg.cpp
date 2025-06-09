class Solution {
  public:
    int countStrings(string &s) {
        int n = s.size();
        vector<int> freq(26, 0);
        for (char c : s)
            freq[c - 'a']++;
        long long total_pairs = 1LL * n * (n - 1) / 2;
        long long same_char_pairs = 0;
        for (int f : freq)
            same_char_pairs += 1LL * f * (f - 1) / 2;
        long long distinct_swaps = total_pairs - same_char_pairs;
        if (same_char_pairs > 0)
            return distinct_swaps + 1;
        else
            return distinct_swaps;
    }
};
