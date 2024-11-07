import java.util.ArrayList;
import java.util.List;

public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        return approach2(nums);
    }

    /**
     * Time Complexity = 2 ms - Beats: 94.83%
     * Space Complexity = 134.34 MB - Beats: 7.59%
     */
    public boolean approach2(int[] nums) {
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE, len = nums.length;
        List<Integer> visited = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] <= num1) {
                num1 = nums[i];
            } else if (nums[i] <= num2) {
                num2 = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Time Complexity = 275ms - Beats: 5.08%
     * Space Complexity = 133.82 MB = Beats: 49.50%
     */
    public boolean approach1(int[] nums) {
        int num1, num2, len = nums.length;
        List<Integer> visited = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            num1 = nums[i];
            num2 = Integer.MAX_VALUE;
            visited.add(num1);
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > num2) {
//                    System.out.println(num1);
//                    System.out.println(num2);
//                    System.out.println(nums[j]);
                    return true;
                } else if (nums[j] > num1) {
                    num2 = nums[j];
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 0, 4, 6};
        System.out.println(new IncreasingTriplet().increasingTriplet(nums));
    }
}
