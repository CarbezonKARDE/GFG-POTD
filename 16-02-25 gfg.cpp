class Solution {
  public:
    vector<int> serialize(Node *root) {
          vector<int> ans;
        queue<Node*> q;
        q.push(root);
        while(!q.empty()){
            auto z=q.front();
            q.pop();
            if(z==NULL){
                ans.push_back(-1);
                continue;
            }
            ans.push_back(z->data);
                q.push(z->left);
                q.push(z->right);
        }
     return ans;  
    }
    Node *deSerialize(vector<int> &arr) {
         int i=0;
        Node* r=new Node(arr[i++]);
        queue<Node*> q;
        q.push(r);
        int n=arr.size();
        while(i<n){
            if(q.empty())
                break;
            auto z=q.front();
            q.pop();
            if(arr[i]!=-1){
                z->left=new Node(arr[i++]);
                q.push(z->left);
            }
            else
                i++;
            if(i>=n)
                break;
            if(arr[i]!=-1){
                z->right=new Node(arr[i++]);
                q.push(z->right);
            }
            else
                i++;
        }   
        return r;
    }
};
