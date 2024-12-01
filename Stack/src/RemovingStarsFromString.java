public class RemovingStarsFromString {

    /**
     * Approach 1
     * Time Complexity = Beats 95.08%
     * Space Complexity = Beats 99.39%
     */
    public String removeStars(String s) {
        int count = 0, len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != '*') {
                if (count > 0) {
                    count--;
                } else {
                    sb.append(s.charAt(i));
                }
            } else {
                count++;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        String s1 = "leet**cod*e";
        String s1 = "erase*****";
        System.out.println(new RemovingStarsFromString().removeStars(s1));
    }
}
