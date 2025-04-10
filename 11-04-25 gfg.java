class Solution {
    ArrayList<Integer> distance;
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        distance = new ArrayList<>();
        PriorityQueue<iPair> pq = new PriorityQueue<>((a, b) -> {
            if(a.second == b.second) return a.first - b.first;
            return a.second - b.second;
        });
        int V = adj.size();
        for (int i = 0; i < V; i++) {
            distance.add(Integer.MAX_VALUE);
        }
        distance.set(src, 0);
        pq.offer(new iPair(src, 0));
        while(!pq.isEmpty()){
            int d1 = pq.peek().second;
            int n1 = pq.peek().first;
            pq.poll();
            for(iPair iP: adj.get(n1)){
                int d2 = iP.second;
                int n2 = iP.first;
                if(d1 + d2 < distance.get(n2)){
                    distance.set(n2, d1+d2);
                    pq.offer(new iPair(n2, distance.get(n2)));
                }
            }
        }
        return distance
    }
}
