import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KthMaxElement {

    List<Integer> heap = new ArrayList<>();

    /**
     * TC: 8.07%
     * SC: 32.76%
     */
    public int findKthLargest(int[] nums, int k) {
        heap = heapify(nums);
        int res = heap.get(1);
        while (k > 0) {
            res = pop();
            k--;
        }
        return res;
    }

    public int pop() {
        int val = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int cur = 1;
        while (cur * 2 < heap.size()) {
            int left = cur * 2, right = cur * 2 + 1;
            if (right < heap.size() && heap.get(right) > heap.get(left) && heap.get(cur) < heap.get(right)) {
                int temp = heap.get(cur);
                heap.set(cur, heap.get(right));
                heap.set(right, temp);
                cur = right;
            } else if (heap.get(cur) < heap.get(left)) {
                int temp = heap.get(cur);
                heap.set(cur, heap.get(left));
                heap.set(left, temp);
                cur = left;
            } else {
                break;
            }
        }
        return val;
    }

    public List<Integer> heapify(int[] nums) {
        List<Integer> heap = new ArrayList<>();
        heap.add(null);
        heap.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int size = heap.size(), i = (size - 1) / 2;
        while (i >= 1) {
            int cur = i;

            while (cur * 2 < size) {
                int left = cur * 2, right = cur * 2 + 1;
                if (right < size && heap.get(right) > heap.get(left) && heap.get(cur) < heap.get(right)) {
                    int temp = heap.get(cur);
                    heap.set(cur, heap.get(right));
                    heap.set(right, temp);
                    cur = right;
                } else if (heap.get(left) > heap.get(cur)) {
                    int temp = heap.get(cur);
                    heap.set(cur, heap.get(left));
                    heap.set(left, temp);
                    cur = left;
                } else {
                    break;
                }
            }
            i -= 1;
        }
        return heap;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        KthMaxElement obj = new KthMaxElement();
        System.out.println(obj.findKthLargest(nums, 2));
    }
}
