public class StringCompression {

    /**
     * Time Complexity = Beats: 99.64%
     * Space Complexity = Beats: 33.07%
     */
    public int compress(char[] chars) {
        int len = 0, count;
        char cur = chars[0];
        count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                count += 1;
            } else {
                char temp = chars[i];
                chars[len] = cur;
                len += 1;
                if (count > 1) {
                    len = appendNumber(chars, len, count);
                }
                cur = temp;
                count = 1;
            }
        }
        chars[len] = cur;
        len += 1;
        if (count > 1) {
            len = appendNumber(chars, len, count);
        }
        return len;
    }

    public int appendNumber(char[] chars, int len, int count) {
        for (char c : Integer.toString(count).toCharArray()) {
            chars[len] = c;
            len += 1;
        }
        return len;
    }

    public static void main(String[] args) {
        char[] input = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c'};
        System.out.println(new StringCompression().compress(input));
        System.out.println(input);
    }
}
