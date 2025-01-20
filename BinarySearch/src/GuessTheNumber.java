public class GuessTheNumber {

    int num = 10;

    /**
     * TC: 100.00%
     * SC: 17.44%
     */
    public int guessNumber(int n) {
        int start = 1, end = n, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            int res = guess(mid);
            if (res == -1) {
                end = mid - 1;
            } else if (res == 1) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int guess(int n) {
        if (n > num) {
            return -1;
        } else if (n < num) {
            return 1;
        } else {
            return 0;
        }
    }
}
