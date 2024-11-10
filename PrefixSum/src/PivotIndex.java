public class PivotIndex {

    /**
     * Best Approach
     * Time Complexity = Beats 100.00%%
     * Space Complexity = Beats 68.09%
     */
    public int pivotIndex(int[] nums) {
        int i = 0, len = nums.length, left = 0, right = 0;
        for (int j = 1; j < len; j++) {
            right += nums[j];
        }
//        System.out.println(left + " " + right);
        if (left == right) {
            return i;
        }
        i++;
        while (i < len && left != right) {
            left += nums[i - 1];
            right -= nums[i];
//            System.out.println(left + " " + right + " : " + i);
            i++;

        }
        i--;
        if (left == right) {
            return i;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 7, 3, 6, 5, 6};
        int[] nums2 = new int[]{1, 2, 3};
        int[] nums3 = new int[]{2, 1, -1};
        int[] nums4 = new int[]{-1, -1, 0, 1, 1, 0};
        System.out.println(new PivotIndex().pivotIndex(nums1));
        System.out.println(new PivotIndex().pivotIndex(nums2));
        System.out.println(new PivotIndex().pivotIndex(nums3));
        System.out.println(new PivotIndex().pivotIndex(nums4));
    }
}
