class Solution {
  public:
    bool isMirror(Node* left, Node* right) {
        if (!left && !right) return true;
        if (!left || !right) return false;
        if (left->data != right->data) return false;
        return isMirror(left->left, right->right) &&
               isMirror(left->right, right->left);
    }
    bool isSymmetric(Node* root) {
        if (!root) return true;
        return isMirror(root->left, root->right);
    }
};
