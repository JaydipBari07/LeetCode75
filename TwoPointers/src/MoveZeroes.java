import java.util.Arrays;

public class MoveZeroes {

    /**
     * Time Complexity = Beats 84.38%
     * Space Complexity = Beats 94.81%
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; i < nums.length & j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i += 1;
            }
        }
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
