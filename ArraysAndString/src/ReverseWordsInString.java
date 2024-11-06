public class ReverseWordsInString {

    public String reverseWords(String s) {
        return reverse(s, 0, s.length());
    }

    public String reverse(String s, int start, int end) {
        int i = start;
        while (start < end && s.charAt(start) != ' ') {
            start += 1;
        }
        int e = start;
        while (start < end && s.charAt(start) == ' ') {
            start += 1;
        }
        if (start < end && i == e) {
            return reverse(s, start, end);
        } else if (start < end) {
            return reverse(s, start, end) + " " + s.substring(i, e);
        } else {
            return s.substring(i, e);
        }
    }

    public static void main(String[] args) {
        String s = "  hello world   ";
        System.out.println(new ReverseWordsInString().reverseWords(s));
    }
}
