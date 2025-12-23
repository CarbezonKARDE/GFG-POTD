class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        Arrays.sort(arr);
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int a = q[0];
            int b = q[1];
            int left = lowerBound(arr, a);
            int right = upperBound(arr, b);
            result.add(right - left);
        }
        return result;
    }
    private int lowerBound(int[] arr, int key) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < key) l = mid + 1;
            else r = mid;
        }
        return l;
    }
    private int upperBound(int[] arr, int key) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= key) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
