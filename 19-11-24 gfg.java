class Solution {
    void nextPermutation(int[] arr) {
        int n=arr.length;
        int num=arr[n-1];
        int i=n-2;
        while(i>=0 && arr[i]>=num){
            num=arr[i];
            i--;
        }
        if(i<0){
            Arrays.sort(arr);
        }
        else{
            num=arr[i];
            int start=i;
            int max=Integer.MAX_VALUE;
            int index=i;
            for(i=i+1;i<n;i++){
                if(arr[i]>num){
                    if(max>=arr[i]){
                        max=arr[i];
                        index=i;
                    }
                }
            }
            int temp=arr[start];
            arr[start]=arr[index];
            arr[index]=temp;
            Arrays.sort(arr,start+1,n);
        }
        
    }
}
