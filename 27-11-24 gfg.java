class Solution {
    public int missingNumber(int[] arr) {
       boolean flag=false;int index=0;
        int n=arr.length;
        Arrays.sort(arr);
       int ans=1;
          for(int i=0;i<n;i++) {
              if(arr[i]==1){
              flag=true;
              index=i;
              }
          }
          if(flag==false)
          return ans;
         for (int i=index;i<n-1;i++){
             if(arr[i]+1!=arr[i+1] && arr[i+1]!=arr[i])
             return arr[i]+1;
         }
       return arr[n-1]+1;
    }
}
