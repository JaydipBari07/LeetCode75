public class MaxTwinSum {

    /**
     * TC: 100%
     * SC: 97.69%
     */
    public int pairSum(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        cur = head;
        int[] res = new int[n / 2];
        int max = 0, i = 0, j = (n / 2) - 1;
        while (cur != null) {
            if (i < n / 2) {
                res[i] = cur.val;
                i++;
            } else {
                max = Math.max(max, res[j] + cur.val);
                j--;
            }
            cur = cur.next;
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 4};
        int[] arr = new int[]{5, 4, 2, 1};
//        int[] arr = new int[]{4, 2, 2, 3};
        System.out.println(new MaxTwinSum().pairSum(LinkedListUtils.createLinkedList(arr)));
    }
}
