public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int len = flowerbed.length;
        while (i < flowerbed.length && n != 0) {
            if (flowerbed[i] == 1) {
                i += 2;
                continue;
            }
            if (i + 1 < len && flowerbed[i + 1] == 1) {
                i += 3;
                continue;
            }
            if (i - 1 >= 0 && flowerbed[i - 1] == 1) {
                i += 1;
                continue;
            }
            n -= 1;
            flowerbed[i] = 1;
            i += 2;
        }
        return n == 0;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        int n = 2;
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, n));
    }
}
