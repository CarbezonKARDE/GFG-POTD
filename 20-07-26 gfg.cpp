class Solution {
  public:
    struct TrieNode {
        TrieNode* child[26];
        int cnt;
        TrieNode() {
            cnt = 0;
            for (int i = 0; i < 26; i++) child[i] = nullptr;
        }
    };
    vector<string> findPrefixes(vector<string>& arr) {
        TrieNode* root = new TrieNode();
        for (string &s : arr) {
            TrieNode* node = root;
            for (char c : s) {
                int idx = c - 'a';
                if (!node->child[idx])
                    node->child[idx] = new TrieNode();
                node = node->child[idx];
                node->cnt++;
            }
        }
        vector<string> ans;
        for (string &s : arr) {
            TrieNode* node = root;
            string prefix = "";
            for (char c : s) {
                int idx = c - 'a';
                node = node->child[idx];
                prefix += c;
                if (node->cnt == 1)
                    break;
            }
            ans.push_back(prefix);
        }
        return ans;
    }
};
