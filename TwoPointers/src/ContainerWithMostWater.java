public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        return twoPointer(height);
    }

    /**
     * Approach 2
     * Time Complexity: Beats 73.54%
     * Space Complexity: Beats 83.85%
     */
    public int twoPointer(int[] height) {
        int maxVol = Integer.MIN_VALUE, area, len = height.length;
        for (int i = 0, j = len - 1; i < j; ) {
            area = calculateArea(i, j, Math.min(height[i], height[j]));
            if (area > maxVol) {
                maxVol = area;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxVol;
    }

    /**
     * Approach 1
     * Time Complexity: Beats 8.15%
     * Space Complexity: Beats 52.01%
     */
    public int brutForce(int[] height) {
        int maxVol = Integer.MIN_VALUE, len = height.length, lastMaxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            if (height[i] > lastMaxHeight) {
                lastMaxHeight = height[i];
                for (int j = i + 1; j < len; j++) {
                    int area = calculateArea(i, j, Math.min(height[i], height[j]));
                    if (area > maxVol) {
                        maxVol = area;
                    }
                }
            }
        }
        return maxVol;
    }

    public int calculateArea(int a1, int a2, int min) {
        return (a2 - a1) * min;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 2, 1};
//        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }
}
