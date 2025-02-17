class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        for ( int i=arr.length-1; i>=arr.length-k; i-- ) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
