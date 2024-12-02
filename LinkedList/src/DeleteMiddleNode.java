import java.util.LinkedList;

public class DeleteMiddleNode {

    public int count = 0, length;


    /**
     * Approach 2
     * TC: 99.89%
     * SC: 49.32%
     */
    public ListNode twoPointerApproach(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        if (head.next == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }


    /**
     * TC: 5.34%
     * SC: 5.95%
     */
    public ListNode deleteMiddle(ListNode head) {
        count++;
        if (head.next == null) {
            length = count;
            if (count == 1) {
                return null;
            }
            return head;
        }
        ListNode node = deleteMiddle(head.next);
        count--;
        if (count == length / 2) {
            head.next = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 7, 1, 2, 6};
//        int[] arr = new int[]{1, 3, 4, 7};
//        int[] arr = new int[]{1, 3};
//        int[] arr = new int[]{1};
        ListNode head = LinkedListUtils.createLinkedList(arr);
        head = new DeleteMiddleNode().twoPointerApproach(head);
//        head = new DeleteMiddleNode().deleteMiddle(head);
        LinkedListUtils.printLinkedList(head);
    }
}
