class Solution {
  public:
    int height(Node* root,int& ans){
        if(!root) return 0;
        int lh=height(root->left,ans);
        int rh=height(root->right,ans);
        ans=max(ans,lh+rh);
        return max(rh,lh)+1;   
    }
   
    int diameter(Node* root) {
        int ans=0;
        height(root,ans);
        return ans;
    }
};
