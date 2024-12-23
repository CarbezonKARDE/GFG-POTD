class Solution {
    public boolean searchRowMatrix(int[][] mat, int x) {
        for(int i=0; i< mat.length; i++){
            for(int k=0; k<mat[i].length; k++){
                if(mat[i][k] == x)
                    return true;
                if(mat[i][k] > x)
                    continue;    
            }
        }
        return false;
    }
}
