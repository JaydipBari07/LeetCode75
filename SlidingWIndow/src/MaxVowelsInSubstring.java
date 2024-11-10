import com.sun.deploy.util.StringUtils;

public class MaxVowelsInSubstring {

    public int maxVowels(String s, int k) {
        return approach1(s, k);
    }

    /**
     * Approach 1
     * Time Complexity = Beats 82.13%
     * Space Complexity = Beats 73.19%
     */
    public int approach1(String s, int k) {
        int len = s.length(), n = k, count = 0, maxCount = 0;
        char cur;
        s = s.toLowerCase();
        String vowels = "aeiou";
        for (int i = 0; i < k; i++) {
            cur = s.charAt(i);
            if (vowels.indexOf(cur) != -1) {
                count++;
            }
        }
        maxCount = count;
        int i = 0;
        while (i < len - k) {
            if (isVowel(s.charAt(i))) {
                count -= 1;
            }
            if (isVowel(s.charAt(n))) {
                count += 1;
                maxCount = Math.max(maxCount, count);
            }
            n += 1;
            i += 1;
        }
        return maxCount;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String input = "abciiidef";
        System.out.println(new MaxVowelsInSubstring().maxVowels(input, 3));
    }
}
