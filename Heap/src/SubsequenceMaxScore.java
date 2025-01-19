import java.util.Arrays;
import java.util.PriorityQueue;

public class SubsequenceMaxScore {

    /**
     * TC: 76.88%
     * SC: 6.11%
     * <p>
     * In this approach, we first make pairs of nums1 and nums2 to keep their indices same.
     * Now we sort these pairs in descending order of nums2.
     * We take first k pairs from this list and add their corresponding nums1 to sum.
     * Now we calculate our result by multiplying the value of nums2 from recent pair.
     * We update the result if current result is greater than prev. one.
     * Now we remove the pair with least nums1 value (to maximize the sum). For doing this, we maintain a min heap and keep adding each removed nums1 value in it.
     * Once we have processed all the pairs, we are left with the highest resulting score.
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pairs = new int[nums1.length][2];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        System.out.println(Arrays.deepToString(pairs));
        int res = 0, sum = 0;
        for (int[] pair : pairs) {
            queue.add(pair[1]);
            sum += pair[1];
            if (queue.size() > k) {
                sum -= queue.remove();
            }
            if (queue.size() == k) {
                res = Math.max(res, sum * pair[0]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 3, 2};
        int[] nums2 = new int[]{2, 1, 3, 4};
        System.out.println(new SubsequenceMaxScore().maxScore(nums1, nums2, 3));
    }
}
