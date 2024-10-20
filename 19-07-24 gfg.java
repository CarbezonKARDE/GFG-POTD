class Solution {
    static class BIT {
        int[] tree;
        int size;
        BIT(int size) {
            this.size = size;
            tree = new int[size + 1];
        }
        void update(int index, int delta) {
            while (index <= size) {
                tree[index] += delta;
                index += index & -index;
            }
        }
        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }
    int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        TreeSet<Integer> sortedSet = new TreeSet<>();
        for (int num : arr) {
            sortedSet.add(num);
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        int index = 1;
        for (int num : sortedSet) {
            indexMap.put(num, index++);
        }
        BIT bit = new BIT(sortedSet.size());
        for (int i = n - 1; i >= 0; i--) {
            int compressedIndex = indexMap.get(arr[i]);
            ans[i] = bit.query(compressedIndex - 1);
            bit.update(compressedIndex, 1);
        }
        return ans;
    }
}
