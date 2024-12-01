import java.util.ArrayDeque;
import java.util.Queue;

public class Dota2Senate {


    /**
     * Approach 1
     * Passed 72/83 cases
     */
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new ArrayDeque<>();
        int i = 0;
        while (i < senate.length()) {
            queue.add(senate.charAt(i));
            i++;
        }
        int count = 0;
        Character prev = null, cur;
        while (count != queue.size()) {
            cur = queue.remove();
            if (prev == null) {
                prev = cur;
                queue.add(cur);
                count++;
            } else {
                if (prev == cur) {
                    count++;
                    queue.add(cur);
                } else {
                    count = 1;
                    prev = queue.remove();
                    queue.add(prev);
                }
            }
        }
        cur = queue.remove();
        if (cur == 'D') {
            return "Dire";
        } else {
            return "Radiant";
        }
    }

    /**
     * TC: 75.81%
     * SC: 75.55%
     */
    public String approach2(String senate) {
        Queue<Character> queue = new ArrayDeque<>();
        int i = 0;
        while (i < senate.length()) {
            queue.add(senate.charAt(i));
            i++;
        }
        int r = 0, d = 0;
        while (r != queue.size() && d != queue.size()) {
            Character cur = queue.remove();
            if (cur == 'D') {
                r--;
                d++;
            } else {
                d--;
                r++;
            }
            if ((r > 0 && cur == 'R') || (d > 0 && cur == 'D')) {
                queue.add(cur);
            }
        }
        if (r > 0) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }

    public static void main(String[] args) {
        String senate = "RD";
//        String senate = "RDD";
//        String senate = "RDDR";
        System.out.println(new Dota2Senate().approach2(senate));
    }
}
