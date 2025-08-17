import java.util.*;

class Solution {
    public void rearrange(int[] arr, int x) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new int[]{arr[i], Math.abs(arr[i] - x), i});
        }
        Collections.sort(list, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i)[0];
        }
    }
}
