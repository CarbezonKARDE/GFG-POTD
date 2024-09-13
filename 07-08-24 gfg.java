class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        int i=0,j=0,l=0;
        int n= arr1.length, m = arr2.length;
        int[] ans = new int[n+m];
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                ans[l++]=arr1[i++];
            }else{
                ans[l++]=arr2[j++];
            }
        }while(i<n){
            ans[l++]=arr1[i++];
        }while(j<m){
            ans[l++]=arr2[j++];
        }
        return ans[k-1];
    }
}
