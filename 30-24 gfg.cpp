class Solution {
  public:
    void inorder(Node* root, vector<int>& vec){
        if(root==NULL)
            return;
        inorder(root->left, vec);
        vec.push_back(root->data);
        inorder(root->right, vec);
    }
    vector<int> merge(Node *root1, Node *root2) {
        vector<int> bs1;
        vector<int> bs2;
        vector<int> ans;
        inorder(root1, bs1);
        inorder(root2, bs2);
        int n = bs1.size();
        int m = bs2.size();
        int i =0, j = 0;
        while(i<n && j<m){
            if(bs1[i] > bs2[j]){
                ans.push_back(bs2[j]);
                j++;
            }
            else{
                ans.push_back(bs1[i]);
                i++;
            }
        }
        while(i<n){
            ans.push_back(bs1[i]);
            i++;
        }
        while(j<m){
            ans.push_back(bs2[j]);
            j++;
        }
        return ans;
    }
};
