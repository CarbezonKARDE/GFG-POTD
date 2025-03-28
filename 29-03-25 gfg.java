class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        PriorityQueue<Pair> p = new PriorityQueue<>((p1, p2) -> 
                        Integer.compare(p1.deadline, p2.deadline));
        for (int i = 0; i < deadline.length; i++) {
            Pair pair = new Pair();
            pair.deadline = deadline[i];
            pair.profit = profit[i];
            p.add(pair);
        }
        ArrayList<Integer> jobs = new ArrayList<>();
        Integer slotsFilled = 0;
        Integer maxProfit = 0;
        PriorityQueue<Integer> profitsPriorityQueue = new PriorityQueue<Integer>();
        while (!p.isEmpty()) {
            Pair pair = p.remove();
            Integer pairDeadline = pair.deadline;
            Integer pairProfit = pair.profit;
            if (slotsFilled < pairDeadline) {
                slotsFilled++;
                maxProfit += pairProfit;
                profitsPriorityQueue.add(pairProfit);
            } else if (pairProfit > profitsPriorityQueue.peek()) {
                Integer minProfitInPriorityQueue = profitsPriorityQueue.remove();
                maxProfit -= minProfitInPriorityQueue;
                maxProfit += pairProfit;
                profitsPriorityQueue.add(pairProfit);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(slotsFilled);
        result.add(maxProfit);
        return result;
    }
}

class Pair {
    Integer deadline, profit;
    public String toString() {
        return String.valueOf(deadline) + ":" + String.valueOf(profit);
    }
}
