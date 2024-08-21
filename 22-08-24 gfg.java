class Solution {
    public String findOrder(String[] dict, int N, int K) {
        List<Integer>[] graph = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph[word1.charAt(j) - 'a'].add(word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        boolean[] visited = new boolean[K];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                topologicalSort(i, graph, visited, stack);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append((char) (stack.pop() + 'a'));
        }

        return result.toString();
    }

    private void topologicalSort(int node, List<Integer>[] graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                topologicalSort(neighbor, graph, visited, stack);
            }
        }
        stack.push(node);
    }
}
