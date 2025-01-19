import java.util.PriorityQueue;

public class TotalCostToHireWorkers {

    /**
     * TC: 97.00%
     * SC: 35.94%
     * In this approach, we maintain two heaps. Both heaps to maintain two batches to choose from (1st one and last one)
     * Each batch has size == candidates
     * We iterate through k times,
     * At each iteration, we add lowest cost from both batches giving priority to left batch in case similar cost is found.
     * After hiring employee from either of the batch, we fill that batch with one more employee which is not in the another batch.
     * This way our batches keep considering candidates from both ends of costs array.
     * At the end of k iterations, we have the least cost of hiring employees.
     */
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> heap1 = new PriorityQueue<>();
        PriorityQueue<Integer> heap2 = new PriorityQueue<>();
        int len = costs.length, s1 = 0, s2 = len - 1;
        long totalCost = 0;
        for (; s1 < len && s1 < candidates; s1++) {
            heap1.add(costs[s1]);
        }
        s1 -= 1;
        for (int i = 0; s2 > s1 && i < candidates; i++, s2--) {
            heap2.add(costs[s2]);
        }
        s2 += 1;
        while (k > 0) {
            if (!heap1.isEmpty() && !heap2.isEmpty()) {
                if (heap1.peek() <= heap2.peek()) {
                    totalCost += heap1.remove();
                    if (s1 + 1 < s2 && s1 + 1 < len) {
                        heap1.add(costs[s1 + 1]);
                        s1 += 1;
                    }
                } else {
                    totalCost += heap2.remove();
                    if (s2 - 1 > s1 && s2 - 1 >= 0) {
                        heap2.add(costs[s2 - 1]);
                        s2 -= 1;
                    }
                }
            } else if (heap2.isEmpty()) {
                totalCost += heap1.remove();
            } else {
                totalCost += heap2.remove();
            }
            k--;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[] costs = new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8};
        int[] costs1 = new int[]{1, 2, 4, 1};
        int[] costs2 = new int[]{31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58};
        int[] costs3 = new int[]{57, 33, 26, 76, 14, 67, 24, 90, 72, 37, 30};
//        System.out.println(new TotalCostToHireWorkers().totalCost(costs1, 3, 4));
//        System.out.println(new TotalCostToHireWorkers().totalCost(costs, 3, 4));
//        System.out.println(new TotalCostToHireWorkers().totalCost(costs2, 11, 2));
        System.out.println(new TotalCostToHireWorkers().totalCost(costs3, 11, 2));
    }
}
