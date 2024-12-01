import java.util.ArrayDeque;
import java.util.Queue;


/**
 * TC: 61.66%
 * SC: 10.90%
 */
public class NumberOfRecentCalls {

    public Queue<Integer> queue;

    public NumberOfRecentCalls() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.add(t);
        int limit = t - 3000;
        while (queue.element() < limit) {
            queue.remove();
        }
        return queue.size();
    }
}
