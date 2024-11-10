public class HighestAltitude {

    /**
     * Best Approach
     * Time Complexity = Beats 100.00%
     * Space Complexity = Beats 85.99%
     */
    public int largestAltitude(int[] gain) {
        int len = gain.length, i = 0, altitude = 0, maxAltitude = 0;
        while (i < len) {
            altitude += gain[i];
            if (gain[i] > 0) {
                maxAltitude = Math.max(altitude, maxAltitude);
            }
            i++;
        }
        return maxAltitude;
    }

    public static void main(String[] args) {
        int[] gain1 = new int[]{-5, 1, 5, 0, -7};
        int[] gain2 = new int[]{-4, -3, -2, -1, 4, 3, 2};
        System.out.println(new HighestAltitude().largestAltitude(gain1));
        System.out.println(new HighestAltitude().largestAltitude(gain2));
    }
}
