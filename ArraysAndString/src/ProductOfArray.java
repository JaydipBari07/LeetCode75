import java.util.Arrays;

public class ProductOfArray {

    public int[] productExceptSelf(int[] nums) {

        // Approach 1           -> beats time complexity - 8.26%, beats space complexity - 5.67%
        /*int len = nums.length;
        multiply(nums, 1, 0, len);
        return nums;*/

        // Approach 2           -> beats time complexity - 99.65%, beats space complexity - 66.18%
        return multiplyApproach2(nums);
    }

    public int[] multiplyApproach2(int[] nums) {
        int len = nums.length;
        int curProduct = nums[0];
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = curProduct;
            curProduct *= nums[i];
        }
        curProduct = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            res[i] *= curProduct;
            curProduct *= nums[i];
        }
        return res;
    }

    public int multiply(int[] nums, int productTillNow, int cur, int len) {
        if (cur < len) {
            int temp = nums[cur];
            if (cur == len - 1) {
                nums[cur] = productTillNow;
                return temp;
            } else {
                int productAhead = multiply(nums, productTillNow * nums[cur], cur + 1, len);
                nums[cur] = productAhead * productTillNow;
                return productAhead * temp;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 1, 2};
        System.out.println(Arrays.toString(new ProductOfArray().productExceptSelf(nums)));
    }
}
