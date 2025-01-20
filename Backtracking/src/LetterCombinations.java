import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    /**
     * TC: 56.75%
     * SC: 49.83%
     * In this approach, we consider each and every combination of letters.
     * We use backtracking approach to append the letter and remove it after getting all its combinations.
     */
    public List<String> letterCombinations(String digits) {
        Map<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        combineLetters(digits, new StringBuilder(), result, map);
        return result;
    }

    public void combineLetters(String digits, StringBuilder sb, List<String> result, Map<Character, String[]> map) {
        if (digits.isEmpty()) {
            result.add(sb.toString());
            return;
        }
        char c = digits.charAt(0);
        digits = digits.substring(1);
        for (String s : map.get(c)) {
            sb.append(s);
            combineLetters(digits, sb, result, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "234";
        System.out.println(new LetterCombinations().letterCombinations(digits));
    }
}
