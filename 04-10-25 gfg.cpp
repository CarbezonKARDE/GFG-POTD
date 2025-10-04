class Solution {
  public:
    vector<string> findExpr(string &s, int target) {
        vector<string> result;
        string path;
        dfs(s, target, 0, 0, 0, path, result);
        sort(result.begin(), result.end());
        return result;
    }
  private:
    void dfs(const string &s, long target, int index, long eval, long prev,
             string path, vector<string> &result) {
        if (index == s.size()) {
            if (eval == target) {
                result.push_back(path);
            }
            return;
        }
        for (int i = index; i < s.size(); i++) {
            if (i != index && s[index] == '0') break;
            string part = s.substr(index, i - index + 1);
            long num = stol(part);
            if (index == 0) {
                dfs(s, target, i + 1, num, num, part, result);
            } else {
                dfs(s, target, i + 1, eval + num, num, path + "+" + part, result);
                dfs(s, target, i + 1, eval - num, -num, path + "-" + part, result);
                dfs(s, target, i + 1, eval - prev + prev * num, prev * num, path + "*" + part, result);
            }
        }
    }
};
