class Solution {
  public:
    void help(Node* root,vector<int>& ans)
    {
        if(root==NULL) return;
        help(root->left,ans);
        ans.push_back(root->data);
        help(root->right,ans);
    }
    int kthSmallest(Node *root, int k) {
        vector<int> ans;
        help(root,ans);
        if(k>ans.size()||root==NULL) return -1;
        return ans[k-1];
    }
};
