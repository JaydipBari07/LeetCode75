import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueOccurances {

    /**
     * Approach 1
     * Time Complexity = Beats 8.44%
     * Space Complexity = Beats 83.12%
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(n -> {
            map.put(n, map.getOrDefault(n, 0) + 1);
        });
        return map.values().stream().distinct().count() == map.size();
    }
}
