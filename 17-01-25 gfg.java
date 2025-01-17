class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int pro=1,n=arr.length,c=0,idx=-1;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                c++;idx=i;
            }
            else
            pro=pro*arr[i];
        }
        if(c>1)return ans;
        else if(c==1){
           ans[idx]=pro;
           return ans;
        }
        for(int i=0;i<n;i++){
            ans[i]=pro/arr[i];
        }
        return ans;
    }
}
