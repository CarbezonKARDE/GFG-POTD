class Solution {
  public:
    struct Node {
        char data;
        int freq;
        int idx;
        Node* left;
        Node* right;
        Node(char d, int f, int i) : data(d), freq(f), idx(i), left(nullptr), right(nullptr) {}
    };
    
    struct Compare {
        bool operator()(Node* a, Node* b) {
            if (a->freq != b->freq) return a->freq > b->freq;
            return a->idx > b->idx;
        }
    };
    
    void collect(Node* root, string code, vector<string>& res) {
        if (!root) return;
        if (!root->left && !root->right) {
            res.push_back(code);
            return;
        }
        collect(root->left, code + "0", res);
        collect(root->right, code + "1", res);
    }
    
    vector<string> huffmanCodes(string &s, vector<int> f) {
        int n = s.size();
        if (n == 0) return {};
        if (n == 1) return {"0"};
        
        priority_queue<Node*, vector<Node*>, Compare> pq;
        
        for (int i = 0; i < n; i++) {
            pq.push(new Node(s[i], f[i], i));
        }
        
        while (pq.size() > 1) {
            Node* a = pq.top(); pq.pop();
            Node* b = pq.top(); pq.pop();
            
            Node* parent = new Node('\0', a->freq + b->freq, min(a->idx, b->idx));
            
            if (a->freq == b->freq) {
                if (a->idx < b->idx) {
                    parent->left = a;
                    parent->right = b;
                } else {
                    parent->left = b;
                    parent->right = a;
                }
            } else {
                parent->left = a;
                parent->right = b;
            }
            
            pq.push(parent);
        }
        
        Node* root = pq.top();
        vector<string> res;
        collect(root, "", res);
        return res;
    }
};
