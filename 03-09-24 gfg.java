class Solution{
    public static int findMin(String str1 ,String str2 ,int i ,int j ,int[][] Dp){
        if(i == str1.length()){
            return str2.length() - j;
        }
        if(j == str2.length()){
            return str1.length() - i;
        }
        if(Dp[i][j] != -1){
            return Dp[i][j];
        }
        if(str1.charAt(i) == str2.charAt(j)){
            return Dp[i][j] = findMin(str1,str2,i+1,j+1,Dp);
        }
        int a = 2 + findMin(str1,str2,i+1,j+1,Dp);
        int b = 1 + findMin(str1,str2,i+1,j,Dp);
        int c = 1 + findMin(str1,str2,i,j+1,Dp);
        
        return Dp[i][j] = Math.min(c,Math.min(a,b));
    }
	public int minOperations(String str1, String str2) { 
	    int[][] Dp = new int[str1.length()][str2.length()];
	    for(int i=0;i<str1.length();i++){
	        Arrays.fill(Dp[i],-1);
	    }
	    return findMin(str1,str2,0,0,Dp);
	} 
}
