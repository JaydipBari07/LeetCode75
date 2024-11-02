import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GreatestCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = -1;
        for (int i : candies) {
            if (i > greatest) {
                greatest = i;
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            res.add(candy + extraCandies >= greatest);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] candies = new int[]{12, 1, 12};
        int extra = 10;
        System.out.println(new GreatestCandies().kidsWithCandies(candies, extra));
    }
}
