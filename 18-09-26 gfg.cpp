class Solution {
  public:
    int absDiff(Node *root) {
        int ans = INT_MAX;
        int prev = -1;
        stack<Node*> st;
        Node* curr = root;
        while (curr != nullptr || !st.empty()) {
            while (curr != nullptr) {
                st.push(curr);
                curr = curr->left;
            }
            curr = st.top();
            st.pop();
            if (prev != -1) {
                ans = min(ans, curr->data - prev);
            }
            prev = curr->data;
            curr = curr->right;
        }
        return ans;
    }
};
