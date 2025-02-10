class Solution {
  public:
    void help(Node* root,int target_sum,int &cnt,unordered_map<int,int> &mp,int current_sum){
        if(root==NULL) return;
        current_sum+=root->data;
        if(mp.find(current_sum-target_sum)!=mp.end()){
            cnt+=mp[current_sum-target_sum];
        }
        mp[current_sum]++;
        help(root->left,target_sum,cnt,mp,current_sum);
        help(root->right,target_sum,cnt,mp,current_sum);
        mp[current_sum]--;
        if(mp[current_sum]==0){
            mp.erase(current_sum);
        }
    }
    int sumK(Node *root, int k) {
        unordered_map<int,int> mp;
        mp[0]=1;
        int cnt=0;
        help(root,k,cnt,mp,0);
        return cnt;
    }
};
