import com.sun.deploy.util.StringUtils;

import java.util.Stack;

public class DecodeString {

    public StringBuilder sb = new StringBuilder();

    public String decodeString(String s) {
        return buildString(s, 0);
    }

    /*
     * TC: 69.84%
     * SC: 58.92%
     */
    public String approach3(String s) {
        StringBuilder cur = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int num = 0, i = 0;
        while (i < s.length()) {
            Character c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + Integer.parseInt(String.valueOf(c));
            } else if (Character.isAlphabetic(c)) {
                cur.append(c);
            } else if (c == '[') {
                stack.push(cur.toString());
                stack.push(String.valueOf(num));
                num = 0;
                cur = new StringBuilder();
            } else if (c == ']') {
                int prevNum = Integer.parseInt(stack.pop());
                String prevStr = stack.pop();
                String curString = cur.toString();
                cur = new StringBuilder();
                for (int j = prevNum; j > 0; j--) {
                    cur.append(curString);
                }
                cur = new StringBuilder(prevStr + cur);
            }
            i++;
        }
        return cur.toString();
    }

    /**
     * Only 29 cases passed out of 34
     */
    public String approach2(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i = s.length() - 1;
        StringBuilder temp = new StringBuilder();
        while (i >= 0) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                if (stack.isEmpty()) {
                    res.append(c);
                } else {
                    temp.append(c);
                }
                i--;
            } else if (c == ']') {
                stack.push(c);
                i--;
            } else if (Character.isDigit(c)) {
                int n = extractNumberInReverse(s, i);
                String t = temp.toString();
                temp.delete(0, temp.length());
                for (int j = 0; j < n; j++) {
                    temp.append(t);
                }
                if (stack.isEmpty()) {
                    res.append(temp);
                    temp.delete(0, temp.length());
                }
                i -= String.valueOf(n).length();
            } else if (c == '[') {
                stack.pop();
                i--;
            }
        }
        return res.reverse().toString();
    }

    /**
     * Approach 1
     * Exceeds time limit
     */
    public String buildString(String s, int start) {
        StringBuilder subSb = new StringBuilder();
        while (start < s.length()) {
            if (Character.isAlphabetic(s.charAt(start))) {
                subSb.append(s.charAt(start));
                start++;
            } else if (Character.isDigit(s.charAt(start))) {
                int repetitions = extractNumber(s, start);
                start += String.valueOf(repetitions).length();
                String subStr = buildString(s, start + 1);
                for (int i = 0; i < repetitions; i++) {
                    subSb.append(subStr);
                }
                start += subStr.length() + 1 + 1;
            } else if (s.charAt(start) == ']') {
                return subSb.toString();
            }
        }
        return subSb.toString();
    }

    public int extractNumber(String s, int start) {
        int n = 0;
        while (Character.isDigit(s.charAt(start))) {
            n = n * 10 + Integer.parseInt(String.valueOf(s.charAt(start)));
            start++;
        }
        return n;
    }

    public int extractNumberInReverse(String s, int start) {
        StringBuilder num = new StringBuilder();
        while (start >= 0 && Character.isDigit(s.charAt(start))) {
            num.append(s.charAt(start));
            start--;
        }
        return Integer.parseInt(num.reverse().toString());
    }

    public static void main(String[] args) {
        String input = "2[abc]10[cd]ef";
//        String input = "100[leetcode]";
//        String input = "3[a2[c]]";
        System.out.println(new DecodeString().approach3(input));
    }
}
