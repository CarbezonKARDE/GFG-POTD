class Solution {
  public:
    int countValid(int n, vector<int>& arr) {
        unordered_set<int> requiredDigits(arr.begin(), arr.end());
        vector<int> otherDigits;
        for (int i = 0; i <= 9; ++i) {
            if (!requiredDigits.count(i)) {
                otherDigits.push_back(i);
            }
        }
        int total = 9 * pow(10, n - 1); // total n-digit numbers
        if (otherDigits.empty()) return total;
        int invalid = 0;
        int firstDigitChoices = 0;
        for (int d : otherDigits) {
            if (d != 0) firstDigitChoices++;
        }
        if (firstDigitChoices == 0) return total;
        invalid = firstDigitChoices * pow(otherDigits.size(), n - 1);
        return total - invalid;
    }
};
