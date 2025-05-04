class Solution {
    public int findTarget(int arr[], int target) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
