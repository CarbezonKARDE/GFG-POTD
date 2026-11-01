class Solution {
    public int maximumSubarray(int[] arr) {
        int normal = arr[0];
        int squared = arr[0] * arr[0];
        int ans = squared;
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            int newSquared = Math.max(
                squared + x,
                Math.max(normal + x * x, x * x)
            );
            int newNormal = Math.max(x, normal + x);
            normal = newNormal;
            squared = newSquared;
            ans = Math.max(ans, squared);
        }
        return ans;
    }
}
