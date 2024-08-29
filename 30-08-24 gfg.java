class Solution {
    ArrayList<Integer> construct(char board[][])
    
    {    int n=board.length;
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[j][i]=='Q')
                {
                    l.add(j+1);
                    break;
                    
                }
            }
        }
        return l;
    }
    void solve( ArrayList<ArrayList<Integer>> ans,int leftrow[],int leftdiag[],int rightdiag[],int n,int col,char board[][])
    {
        if(col==n)
        {
            ans.add(new ArrayList<>(construct(board)));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(leftrow[i]==0 && leftdiag[i+col]==0 && rightdiag[n-1+col-i]==0)
            {
                board[i][col]='Q';
                leftrow[i]=1;
                leftdiag[i+col]=1;
                rightdiag[n-1+col-i]=1;
                solve(ans,leftrow,leftdiag,rightdiag,n,col+1,board);
                board[i][col]='.';
                leftrow[i]=0;
                leftdiag[i+col]=0;
                rightdiag[n-1+col-i]=0;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        int leftrow[]=new int[n];
        int rightdiag[]=new int[2*n-1];
        int leftdiag[]=new int[2*n-1];
        solve(ans,leftrow,leftdiag,rightdiag,n,0,board);
        return ans;
    }
}
