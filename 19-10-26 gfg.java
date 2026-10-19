class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] state = new int[n];
        int goodCount = 0;
        for (int i = 0; i < n; i++) {
            if (state[i] != 0) {
                continue;
            }
            java.util.ArrayList<Integer> path =
                new java.util.ArrayList<>();
            int curr = i;
            while (curr >= 0 && curr < n && state[curr] == 0) {
                state[curr] = 1;
                path.add(curr);
                if (arr[curr] == 0) {
                    break;
                }
                curr = curr + arr[curr];
            }
            int result;
            if (curr < 0 || curr >= n) {
                result = 2;
            } else if (state[curr] == 1) {
                result = 3;
            } else {
                result = state[curr];
            }
            for (int j = path.size() - 1; j >= 0; j--) {
                int idx = path.get(j);
                if (arr[idx] == 0) {
                    result = 3;
                }
                state[idx] = result;
                if (result == 2) {
                    goodCount++;
                }
            }
        }
        return goodCount;
    }
}
