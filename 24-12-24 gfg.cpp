class Solution {
  public:
    bool searchMatrix(vector<vector<int>> &mat, int x) {
        int row=mat.size();
        int cols=mat[0].size();
        int i=0;
        int j=cols-1;
        while(i<row&&j>=0){
            if(mat[i][j]==x) return 1;
            else if(mat[i][j]>x) j--;
            else i++;
        }
        return false;
    }
};
