class Solution {
  public:
    string longestString(vector<string> &arr) {
        unordered_set<string> dict(arr.begin(), arr.end());
        sort(arr.begin(), arr.end());
        string result = "";
        for (string word : arr) {
            bool valid = true;
            for (int i = 1; i < word.size(); ++i) {
                if (dict.find(word.substr(0, i)) == dict.end()) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                if (word.size() > result.size() || (word.size() == result.size() && word < result)) {
                    result = word;
                }
            }
        }
        return result;
    }
};
