public class KokoEatingBananas {

    /**
     * TC: 52.26%
     * SC: 45.23%
     * Total iterations to eat all bananas in h hours will lie between 1 and the max between the piles.
     * So we start calculating hours to finish each pile from 1 to the max pile.
     * To improve the time complexity, we use binary search to increment or decrement the value of k.
     */
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = piles[0], mid, k = min;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        while (min <= max) {
            mid = min + (max - min) / 2;
            if (canEatBananas(piles, mid, h)) {
                max = mid - 1;
                k = mid;
            } else {
                min = mid + 1;
            }
        }
        return k;
    }

    public boolean canEatBananas(int[] piles, int k, int h) {
        int count = 0;
        for (int pile : piles) {
            count += (int) Math.ceil((double) pile / k);
            if (count > h) {
                return false;
            }
        }
        return count <= h;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{3, 6, 7, 11};
        int[] piles2 = new int[]{30, 11, 23, 4, 20};
        int[] piles3 = new int[]{312884470};
//        System.out.println(new KokoEatingBananas().minEatingSpeed(piles, 8));
//        System.out.println(new KokoEatingBananas().minEatingSpeed(piles2, 5));
        System.out.println(new KokoEatingBananas().minEatingSpeed(piles3, 312884469));
    }
}
