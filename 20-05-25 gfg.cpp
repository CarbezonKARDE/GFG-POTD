
class Solution {
  public:
    int  bfs(int target,unordered_map<int,vector<int>>&mp){
        int ans=0;
        unordered_set<int>st;
        queue<int>q;
        q.push(target);
        int timer=0;
        st.insert(target);
        while(!q.empty()){
            int size=q.size();
            timer++;
            for(int i=0;i<size;i++){
                int front=q.front();
                q.pop();
                for(auto j:mp[front]){
                    if(st.find(j)==st.end()){
                        st.insert(j);
                        q.push(j);
                    }
                }
            }
            
        }
        return timer-1;
    }
    void bfs2(Node* root, unordered_map<int,vector<int>>&mp){
        queue<Node*>q;
        q.push(root);
        while(!q.empty()){
            auto node=q.front();
            q.pop();
            if(node->left){
                mp[node->data].push_back(node->left->data);
                mp[node->left->data].push_back(node->data);
                q.push(node->left);
            }
            if(node->right){
                mp[node->data].push_back(node->right->data);
                mp[node->right->data].push_back(node->data);
                q.push(node->right);
            }
        }
    }
    int minTime(Node* root, int target) 
    {
        unordered_map<int,vector<int>>mp;
        bfs2(root,mp);
        return bfs(target,mp);
    }
};
