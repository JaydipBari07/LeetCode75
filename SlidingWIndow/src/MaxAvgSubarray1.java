public class MaxAvgSubarray1 {

    /**
     * Approach 1
     * Time Complexity = Beats 85.08%
     * Space Complexity = Beats 33.26%
     */
    public double findMaxAverage(int[] nums, int k) {
        double res = 0.0, maxSum;
        for (int i = 0; i < k; i++) {
            res += nums[i];
        }
        maxSum = res;
        int len = nums.length, i = 0, j = k;
        while (i < len - k) {
            maxSum = maxSum - nums[i] + nums[j];
            j++;
            i++;
            if (maxSum > res) {
                res = maxSum;
            }
        }
        return res / k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        System.out.println(new MaxAvgSubarray1().findMaxAverage(nums, 4));
    }
}
