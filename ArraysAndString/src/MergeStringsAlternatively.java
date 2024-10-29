public class MergeStringsAlternatively {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder mergedString = new StringBuilder();
        int l1 = 0, l2 = 0;
        int s1 = word1.length(), s2 = word2.length();
        while (l1 < s1 && l2 < s2) {
            if (l2 < l1) {
                mergedString.append(word2.charAt(l2));
                l2 += 1;
            } else {
                mergedString.append(word1.charAt(l1));
                l1 += 1;
            }
        }
        if (l1 < s1) {
            mergedString.append(word1.substring(l1));
        } else if (l2 < s2) {
            mergedString.append(word2.substring(l2));
        }
        return mergedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MergeStringsAlternatively().mergeAlternately("abc", "pqrzse"));
    }
}


// 100% beats in runtime
// 85.18% beats in space complexity