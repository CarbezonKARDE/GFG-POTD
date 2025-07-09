class TrieNode {
public:
    TrieNode* children[26];
    bool isEnd;
    string word;
    TrieNode() {
        isEnd = false;
        word = "";
        for (int i = 0; i < 26; i++) children[i] = nullptr;
    }
};
class Solution {
public:
    string longestString(vector<string>& words) {
        TrieNode* root = new TrieNode();
        for (string& word : words) {
            TrieNode* node = root;
            for (char ch : word) {
                int idx = ch - 'a';
                if (!node->children[idx])
                    node->children[idx] = new TrieNode();
                node = node->children[idx];
            }
            node->isEnd = true;
            node->word = word;
        }
        string result = "";
        dfs(root, result);
        return result;
    }
    void dfs(TrieNode* node, string& result) {
        if (!node->isEnd && node->word != "") return;

        if (node->word.length() > result.length() || 
            (node->word.length() == result.length() && node->word < result)) {
            result = node->word;
        }
        for (int i = 0; i < 26; ++i) {
            if (node->children[i]) {
                dfs(node->children[i], result);
            }
        }
    }
};
