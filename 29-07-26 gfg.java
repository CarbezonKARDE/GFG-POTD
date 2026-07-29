import java.util.*;
class Solution {
    int minSubsets(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr)
            set.add(x);
        int count = 0;
        for (int x : arr) {
            if (!set.contains(x - 1))
                count++;
        }
        return count;
    }
}
