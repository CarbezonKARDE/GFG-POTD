struct base {
    int sum;
    bool isSum;
};
class Solution {
  public:
    base helper(Node* root) {
        base ans;
        if (root == NULL) {
            ans.sum = 0;
            ans.isSum= true;
            return ans;
        }
        base ans1 = helper(root->left);
        base ans2 = helper(root->right);
        ans.sum = ans1.sum + ans2.sum + root->data;
        ans.isSum = ans1.isSum&&ans2.isSum;
        int expected_sum = ans1.sum + ans2.sum;
        if(expected_sum>0){
            ans.isSum = ans.isSum&&(expected_sum == root->data);
        }
        return ans;
    }
    bool isSumTree(Node* root) {
        return helper(root).isSum;
    }
};
