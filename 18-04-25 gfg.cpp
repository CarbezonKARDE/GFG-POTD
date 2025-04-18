class Node {
public:
    Node* children[26];
    bool isLeaf;
    Node() {
        isLeaf = false;
        for (int i = 0; i < 26; i++) {
            children[i] = NULL;
        }
    }
};
class Trie {
  public:
    Node* root = new Node();
    Trie() {
    }
    void insert(string &word) {
        int n = word.size();
        Node* curr = root;
        for (int i = 0; i < n; i++){
            if (i == n - 1){
                if (curr -> children[word[i] - 'a'] != NULL){
                    curr = curr -> children[word[i] - 'a'];
                }
                else{
                    Node* node = new Node();
                    curr -> children[word[i] - 'a'] = node;
                    curr = node;
                }
                curr -> isLeaf = true;
            }
            else{
                if (curr -> children[word[i] - 'a'] != NULL){
                    curr = curr -> children[word[i] - 'a'];
                }
                else{
                    Node* node = new Node();
                    curr -> children[word[i] - 'a'] = node;
                    curr = node;
                }
            }
        }
    }
    bool search(string &word) {
        Node* curr = root;
        int n = word.size();
        for (int i = 0; i < n; i++){
            if (curr -> children[word[i] - 'a'] == NULL){
                return false;
            }
            curr = curr -> children[word[i] - 'a'];
        }
        return curr -> isLeaf;
    }
    bool isPrefix(string &word) {
        Node* curr = root;
        int n = word.size();
        for (int i = 0; i < n; i++){
            if (curr -> children[word[i] - 'a'] == NULL){
                return false;
            }
            curr = curr -> children[word[i] - 'a'];
        }
        return true;
    }
};
