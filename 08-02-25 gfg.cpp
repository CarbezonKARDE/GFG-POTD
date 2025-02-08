class Solution {
  public:
    vector<int> result;
    bool isLeafNode(Node* root){
        if(!root-> left && !root-> right)
            return true;
        return false;
    }
    void getLeftNodes(Node* root){
        Node* curr= root-> left;
        while(curr){
            if(!isLeafNode(curr))
                result.push_back(curr-> data);
            if(curr-> left)   
                curr= curr-> left;
            else
                curr= curr-> right;
        }
    }
    void getLeafNodes(Node* root){
        if(isLeafNode(root)){
            result.push_back(root-> data);
            return;
        }
        if(root-> left)
            getLeafNodes(root-> left);
        if(root-> right)
            getLeafNodes(root-> right);
    }
    void getRightNodes(Node* root){
        Node* curr= root-> right;
        vector<int> temp;
        while(curr){
            if(!isLeafNode(curr))
                temp.push_back(curr-> data);
            if(curr-> right)
                curr= curr-> right;
            else
                curr= curr-> left;
        }
        for(int i= temp.size()-1; i >= 0; i--){
            result.push_back(temp[i]);
        }
    }
    vector<int> boundaryTraversal(Node *root) {
        if(!root)
            return result;
        if(!isLeafNode(root))
            result.push_back(root-> data);
        getLeftNodes(root);
        getLeafNodes(root);
        getRightNodes(root);
        return result;
    }
};
