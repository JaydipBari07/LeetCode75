import java.util.PriorityQueue;
import java.util.Stack;

/**
 * TC: 41.40%
 * SC: 38.26%
 */
public class SmallestInfiniteSet {

    PriorityQueue<Integer> heap;

    public SmallestInfiniteSet() {
        heap = new PriorityQueue<>();
        heap.add(1);
    }

    public int popSmallest() {
        int num = heap.remove();
        if (heap.isEmpty()) {
            heap.add(num + 1);
        }
        return num;
    }

    public void addBack(int num) {
        if (num < heap.peek()) {
            heap.add(num);
        } else {
            Stack<Integer> stack = new Stack<>();
            while (!heap.isEmpty() && num > heap.peek()) {
                stack.add(heap.remove());
            }
            if (!heap.isEmpty() && heap.peek() > num) {
                heap.add(num);
            }
            while (!stack.isEmpty()) {
                heap.add(stack.pop());
            }
        }
    }
}
