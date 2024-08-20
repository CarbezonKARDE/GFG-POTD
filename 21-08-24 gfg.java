class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
          List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[src] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graph.get(currentNode)) {
                if (distance[neighbor] == -1) { // Not visited
                    distance[neighbor] = distance[currentNode] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        return distance;
    }
}
