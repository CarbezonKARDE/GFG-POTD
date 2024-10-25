class Solution {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        ArrayList<Integer>ans=new ArrayList<>();
        int i=0;
        int j=n-1;
        while(i<j){
            ans.add(arr[j]);
            j--;
            ans.add(arr[i]);
            i++;
        }
        if(i==j){
            ans.add(arr[i]);
        }
        return ans;
    }
}
