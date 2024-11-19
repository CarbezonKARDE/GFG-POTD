class Solution {
  public:
    unordered_map<string, int> m;
    string solve(Node* root, vector<Node*> &ans){
        if(!root){
            return "$";
        }
        string s = "";
        s = s + to_string(root -> data);
        s = s + solve(root -> left, ans);
        s = s + solve(root -> right , ans);
        
        m[s]++;
        if(m[s] == 2){
            ans.push_back(root);
        }
        return s;
    }
    vector<Node*> printAllDups(Node* root) {
        m.clear();
        vector<Node*> ans;
        solve(root, ans);
        return ans;    
    }
};
