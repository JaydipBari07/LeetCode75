public class LongestSubarrayOfOnes {

    /**
     * Best Approach
     * Time Complexity = Beats 100.00%
     * Space Complexity = Beats 85.36%
     */
    public int longestSubarray(int[] nums) {
        int count = 0, maxCount = 0, i = 0, j = 0, len = nums.length;
        boolean deleted = false;
        while (j < len) {
            if (nums[j] == 1) {
                j++;
                count++;
            } else {
                if (!deleted) {
                    deleted = true;
                    j++;
                } else {
                    if (nums[i] == 0) {
                        i++;
                        j++;
                    } else {
                        maxCount = Math.max(count, maxCount);
                        System.out.println(i + " " + j + " : " + count);
                        while (nums[i] != 0) {
                            i++;
                            count--;
                        }
                        j++;
                        i++;
                    }
                }
            }
        }
        if (!deleted) {
            count--;
        }
        System.out.println(i + " " + j + " : " + count);
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 0, 1};
        int[] nums2 = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
        int[] nums3 = new int[]{1, 1, 1};
        System.out.println(new LongestSubarrayOfOnes().longestSubarray(nums1));
        System.out.println(new LongestSubarrayOfOnes().longestSubarray(nums2));
        System.out.println(new LongestSubarrayOfOnes().longestSubarray(nums3));
    }
}
