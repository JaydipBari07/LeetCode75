import sun.security.util.KnownOIDs;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayDifference {

    /**
     * Approach 1
     * Time Complexity = Beats 5.09%
     * Space Complexity = Beats 39.83%
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> n1 = Arrays.stream(nums1).distinct().boxed().collect(Collectors.toList());
        List<Integer> n2 = Arrays.stream(nums2).distinct().boxed().collect(Collectors.toList());
        List<Integer> removeElements = n1.stream().filter(n2::contains).collect(Collectors.toList());
        n1.removeAll(removeElements);
        n2.removeAll(removeElements);
        return Arrays.asList(n1, n2);
    }

    /**
     * Approach 2
     * Time Complexity = Beats 25.39%
     * Space Complexity = Beats 59.44%
     */
    public List<List<Integer>> approach2(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        res.add(s1.stream().filter(n->!s2.contains(n)).collect(Collectors.toList()));
        res.add(s2.stream().filter(n->!s1.contains(n)).collect(Collectors.toList()));
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 3};
        int[] nums2 = new int[]{1, 1, 2, 2};
        System.out.println(new ArrayDifference().findDifference(nums1, nums2));
        System.out.println(new ArrayDifference().approach2(nums1, nums2));
    }
}
