class Solution {
  public:
    void helper(Node* root,int sum,int& total)
    {
        if(!root)
        {
            return;
        }
        sum = sum*10 + root->data;
        if(!root->left && !root->right)
        {
            total += sum;
        }
        if(root->left)
        {
            helper(root->left,sum,total);
        }
        if(root->right)
        {
            helper(root->right,sum,total);
        }
    }
    int treePathsSum(Node *root) 
    {
        int total = 0;
        helper(root,0,total);
        return total;
    }
};
