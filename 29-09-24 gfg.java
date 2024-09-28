class Solution {
    int totalCount(int k, int[] arr) {
        int ans = 0 ;
        for(int i = 0;i<arr.length;i++)
        {
            ans += (int)Math.ceil(1.0 * arr[i] / k) ;
        }
        return ans;
    }
}
