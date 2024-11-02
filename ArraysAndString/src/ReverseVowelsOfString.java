import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseVowelsOfString {

    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] input = s.toCharArray();
        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (vowels.indexOf((input[i])) >= 0) {
                v.add(i);
            }
        }
        int size = v.size();
        for (int i = 0, j = size - 1; i < size && j >= 0 && i < j; j--, i++) {
            char temp = input[v.get(i)];
            input[v.get(i)] = input[v.get(j)];
            input[v.get(j)] = temp;
        }
        return String.valueOf(input);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfString().reverseVowels("leetcode"));
    }
}
