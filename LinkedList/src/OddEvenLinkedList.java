public class OddEvenLinkedList {

    /**
     * TC: 100%
     * SC: 54.64%
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null || head.next.next == null) {
            return head;
        }
        ListNode even = head.next;
        ListNode oddCur = head;
        ListNode evenCur = even;
        while (evenCur.next != null) {
            oddCur.next = oddCur.next.next;
            if (evenCur.next.next != null) {
                evenCur.next = evenCur.next.next;
            } else {
                evenCur.next = null;
                break;
            }
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        if (oddCur.next == evenCur) {
            oddCur.next = even;
        } else {
            oddCur.next.next = even;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, 5, 6, 4, 7};
//        int[] arr = new int[]{1, 2, 3, 4, 5};
//        int[] arr = new int[]{1,2,3,4};
        LinkedListUtils.printLinkedList(new OddEvenLinkedList().oddEvenList(LinkedListUtils.createLinkedList(arr)));
    }
}
