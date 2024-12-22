class Solution {
  public:
    bool matSearch(vector<vector<int>> &mat, int x) {
        int n=mat.size(),m=mat[0].size();
        int low=0,high=m-1;
        while(low<n && high>=0){
            if(mat[low][high]==x)return true;
            if(mat[low][high]>x)high--;
            else low++;
        }
        return false;
    }
};
