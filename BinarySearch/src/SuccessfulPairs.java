import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SuccessfulPairs {

    /**
     * TC: 8.42%
     * SC: 86.37%
     * In this approach, we calculate the required minimum multiplier for each spell and search it in potions array.
     * For searching through potions array, we are using binary search, so we have to sort the potions array first.
     * This way, when we find minimum multiplier of spell in potions array, we find its index and calculate count of all further potions and update in the spells array itself.
     * We use hashmap for storing earlier search results to avoid rework and improve time complexity.
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            if (map.containsKey(spell)) {
                spells[i] = map.get(spell);
            } else {
                long div = (long) Math.ceil((double) success / spell);
                int res;
                res = search(div, potions);
                spells[i] = res;
                map.put(spell, res);
            }
        }
        return spells;
    }

    private int search(long num, int[] potions) {
        int start = 0, mid, len = potions.length, end = len - 1, res = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (potions[mid] < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
                res = len - mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] spells = new int[]{3, 1, 2};
        int[] potions = new int[]{8, 5, 8};
        System.out.println(Arrays.toString(new SuccessfulPairs().successfulPairs(spells, potions, 16)));
    }
}
