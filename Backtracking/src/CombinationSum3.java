import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    /**
     * TC: 100.00%
     * SC: 27.26%
     * In this approach, we try combination of all k numbers from 1-9.
     * Each time, sum exceeds n, we just break out of the loop and do not consider further numbers.
     * We use backtracking to add and remove the current considered number in result.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(result, n, k, 0, 0, new ArrayList<>());
        return result;
    }

    public void findCombinations(List<List<Integer>> result, int n, int k, int cur, int sum, List<Integer> curRes) {
        if (sum > n || (sum < n && k == 0)) {
            return;
        } else if (sum == n && k == 0) {
            result.add(new ArrayList<>(curRes));
            return;
        }
        for (int i = cur + 1; i <= 9; i++) {
            sum += i;
            if (sum > n) {
                break;
            }
            curRes.add(i);
            findCombinations(result, n, k - 1, i, sum, curRes);
            curRes.remove(curRes.size() - 1);
            sum -= i;
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 9));
        System.out.println(new CombinationSum3().combinationSum3(3, 7));
        System.out.println(new CombinationSum3().combinationSum3(4, 1));
    }
}
