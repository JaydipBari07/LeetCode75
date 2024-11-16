import java.util.*;
import java.util.stream.Collectors;

public class CloseStrings {

    /**
     * Approach 2
     * Time Complexity = Beats 40.78%
     * Space Complexity = Beats 11.49%
     */
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (Character c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (Character c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }
        List<Integer> l1 = new ArrayList<>(map1.values());
        List<Integer> l2 = new ArrayList<>(map2.values());
        l1.sort(Comparator.comparing(Integer::intValue));
        l2.sort(Comparator.comparing(Integer::intValue));
        return l1.equals(l2);
    }

    /**
     * Approach 1: Wasn't accepted.
     * I was trying to actually perform all the operations and convert word1 into word2 which was quite complex task.
     */
    public boolean approach1(String word1, String word2) {
        char[] s1 = word1.toCharArray(), s2 = word2.toCharArray();
        int len = s1.length;
        System.out.println(word1);
        System.out.println(word2);
        if (len == s2.length) {
            Map<Character, Integer> s1Map = createCountsMap(s1);
            Map<Character, Integer> s2Map = createCountsMap(s2);
            for (Character c : s1Map.keySet()) {
                if (!Objects.equals(s2Map.get(c), s1Map.get(c))) {
                    Character ch = findMatchingCountChar(s2Map, s1Map.get(c));
                    Integer count1 = s1Map.get(c);
                    Integer count2 = s1Map.get(ch);
                    System.out.println("Replacing " + c + " with " + ch);
                    word1 = replaceChars(word1, c, ch);
                    s1Map.put(c, count2);
                    s1Map.put(ch, count1);
                }
            }

            System.out.println(s1Map);
            System.out.println(s2Map);
            System.out.println(word1);
            System.out.println(word2);
            for (Character c : s1Map.keySet()) {
                if (!Objects.equals(s2Map.get(c), s1Map.get(c))) {
                    return false;
                }
            }
            int i = 0;
            while (i < word1.length() - 1) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    System.out.println("Searching " + word2.charAt(i) + " in " + word1 + " from index: " + (i + 1));
                    int index = word1.indexOf(word2.charAt(i), i + 1);
                    if (index >= 0) {
                        word1 = swapChars(word1, i, index);
                        System.out.println(word1);
                    }
                }
                i++;
            }
            return word1.equals(word2);
        }
        return false;
    }

    public Character findMatchingCountChar(Map<Character, Integer> map, Integer count) {
        return map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), count)).map(Map.Entry::getKey).findFirst().orElse(null);
    }

    public Map<Character, Integer> createCountsMap(char[] s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public String replaceChars(String word, char a, char b) {
        char[] s = word.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == a) {
                s[i] = b;
            } else if (s[i] == b) {
                s[i] = a;
            }
        }
        return String.valueOf(s);
    }

    public String swapChars(String word, int i, int j) {
        char[] s = word.toCharArray();
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        return String.valueOf(s);
    }

    public static void main(String[] args) {
//        String word1 = "cabbba", word2 = "abbccc";
//        String word1 = "abbzccca", word2 = "babzzczc";
//        String word1 = "a", word2 = "aa";
        String word1 = "abc", word2 = "bca";
        CloseStrings cs = new CloseStrings();
        System.out.println(cs.closeStrings(word1, word2));
    }
}
