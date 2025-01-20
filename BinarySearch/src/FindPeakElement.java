public class FindPeakElement {

    /**
     * TC: 100.00%
     * SC: 69.11%
     * In this approach, at each iteration we find mid-index.
     * If left of this mid is less than that and right side is higher, then we move our search in right part by updating start to mid+1
     * We move our search to left part if the opposite happens.
     * If current mid positioned element is less than both its neighbours, we move our search to left direction.
     * If current mid is a peak, i.e. its neighbours are less than that, then we just return that mid-index.
     * We also consider the fact that index -1 and n are both negative infinities.
     * We maintain a result throughout the solution and return it at the end.
     */
    public int findPeakElement(int[] nums) {
        int len = nums.length, start = 0, end = len - 1, mid, res = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if ((mid - 1 < 0 || nums[mid - 1] < nums[mid]) && (mid + 1 == len || nums[mid + 1] > nums[mid])) {
                start = mid + 1;
                res = mid;
            } else if ((mid - 1 < 0 || nums[mid - 1] > nums[mid]) && (mid + 1 == len || nums[mid + 1] < nums[mid])) {
                end = mid - 1;
                res = mid;
            } else if ((mid - 1 >= 0 && nums[mid - 1] > nums[mid]) && (mid + 1 < len && nums[mid + 1] > nums[mid])) {
                end = mid - 1;
                res = end;
            } else {
                return mid;
            }
        }
        return res;
    }
}
