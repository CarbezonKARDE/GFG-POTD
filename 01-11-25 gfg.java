class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] req : prerequisites) {
            int course = req[0];
            int prereq = req[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int course = queue.poll();
            result.add(course);

            for(int nextCourse : adj.get(course)) {
                indegree[nextCourse]--;
                if(indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        if(result.size() == n) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }
}
