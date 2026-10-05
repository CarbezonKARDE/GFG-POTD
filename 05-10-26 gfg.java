class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = arr.length + 1;
        for (int i = 2; i <= n; i++) {
            int[] dist = new int[i];
            int curr = i;
            int steps = 0;
            while (curr != 1) {
                curr = arr[curr - 2];
                steps++;
                dist[curr] = steps;
            }
            for (int j = 1; j < i; j++) {
                if (dist[j] > 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    temp.add(dist[j]);
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
