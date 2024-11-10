public class MaxConsecutiveOnes3 {

    /**
     * Best Approach
     * Time Complexity = Beats 100.00%
     * Space Complexity = Beats 78.91%
     */
    public int longestOnes(int[] nums, int k) {
        int count = 0, maxCount = Integer.MIN_VALUE, i = 0, j = 0, n = k, len = nums.length;
        while (j < len) {
            if (nums[j] == 1) {
                count++;
                j++;
            } else {
                if (n > 0) {
                    n--;
                    count++;
                    j++;
                } else {
                    if (nums[i] == 0) {
                        i++;
                        j++;
                    } else {
                        System.out.println(i + " " + j + " : " + count);
                        maxCount = Math.max(count, maxCount);
//                        n = k;
                        count--;
                        i++;
                    }
                }
            }
        }
        i--;
        while (i >= 0 && (n > 0 || nums[i] == 1)) {
            if (nums[i] == 0) {
                n--;
            }
            i--;
            count++;
        }
        System.out.println(i + " " + j + " : " + count);
        maxCount = Math.max(count, maxCount);
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] nums2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int[] nums3 = {1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1};
        System.out.println(new MaxConsecutiveOnes3().longestOnes(nums1, 2));
        System.out.println(new MaxConsecutiveOnes3().longestOnes(nums2, 3));
        System.out.println(new MaxConsecutiveOnes3().longestOnes(nums3, 9));
    }

}
