import java.util.*;
class Solution {
    public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        long sum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> freqToVals = new TreeMap<>();
        Runnable add = null;
        Runnable remove = null;
        java.util.function.Consumer<Integer> insert = x -> {
            int oldFreq = freq.getOrDefault(x, 0);
            if (oldFreq > 0) {
                TreeSet<Integer> set = freqToVals.get(oldFreq);
                set.remove(x);
                if (set.isEmpty()) freqToVals.remove(oldFreq);
            }
            int newFreq = oldFreq + 1;
            freq.put(x, newFreq);
            freqToVals.computeIfAbsent(newFreq, z -> new TreeSet<>()).add(x);
        };
        java.util.function.Consumer<Integer> erase = x -> {
            int oldFreq = freq.get(x);
            TreeSet<Integer> set = freqToVals.get(oldFreq);
            set.remove(x);
            if (set.isEmpty()) freqToVals.remove(oldFreq);

            if (oldFreq == 1) {
                freq.remove(x);
            } else {
                int newFreq = oldFreq - 1;
                freq.put(x, newFreq);
                freqToVals.computeIfAbsent(newFreq, z -> new TreeSet<>()).add(x);
            }
        };
        for (int i = 0; i < k; i++) {
            insert.accept(arr[i]);
        }
        for (int i = k; i <= n; i++) {
            int maxFreq = freqToVals.lastKey();
            int mode = freqToVals.get(maxFreq).first();
            sum += mode;
            if (i == n) break;
            erase.accept(arr[i - k]);
            insert.accept(arr[i]);
        }
        return (int) sum;
    }
}
