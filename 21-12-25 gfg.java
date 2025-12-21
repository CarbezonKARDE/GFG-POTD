class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];
            int first = firstOccurrence(arr, x, l);
            int last = lastOccurrence(arr, x, r);
            if (first == -1 || last == -1 || first > last) {
                result.add(0);
            } else {
                result.add(last - first + 1);
            }
        }
        return result;
    }
    private int firstOccurrence(int[] arr, int x, int l) {
        int low = l, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    private int lastOccurrence(int[] arr, int x, int r) {
        int low = 0, high = r;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
