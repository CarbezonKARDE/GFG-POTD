import java.util.*;
class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        int[] outdegree = new int[V];
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            reverseGraph.get(v).add(u);
            outdegree[u]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(outdegree[i] == 0){
                queue.offer(i);
            }
        }
        boolean[] safe = new boolean[V];
        while(!queue.isEmpty()){
            int node = queue.poll();
            safe[node] = true;
            for(int neighbor : reverseGraph.get(node)){
                outdegree[neighbor]--;
                if(outdegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(safe[i]){
                ans.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
