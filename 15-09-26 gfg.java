class Solution {
    public int getCount(Node root, int k) {
        ArrayList<Integer> costs = new ArrayList<>();
        collectLeafCosts(root, 1, costs);
        Collections.sort(costs);
        int count = 0;
        for (int cost : costs) {
            if (k < cost)
                break;
            k -= cost;
            count++;
        }
        return count;
    }
    private void collectLeafCosts(Node node, int level, ArrayList<Integer> costs) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            costs.add(level);
            return;
        }
        collectLeafCosts(node.left, level + 1, costs);
        collectLeafCosts(node.right, level + 1, costs);
    }
}
