import com.sun.xml.internal.ws.util.StringUtils;

public class IsSubsequence {

    /**
     * Time Complexity = Beats 100%
     * Space Complexity = Beats 96.74&
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        char cur = s.charAt(0);
        int i = 0, len1 = s.length(), len2 = t.length();
        for (int j = 0; j < len2; j++) {
            if (cur == t.charAt(j)) {
                i += 1;
                if (i < len1)
                    cur = s.charAt(i);
                else
                    break;
            }
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        String s1 = "", s2 = "ahbgdc";

        System.out.println(new IsSubsequence().isSubsequence(s1, s2));
    }
}
