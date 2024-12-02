public class ReverseLinkedList {

    public ListNode newHead;

    /**
     * TC: 100%
     * SC: 70.98%
     */
    public ListNode reverseList(ListNode head) {
        reverse(head).next = null;
        return newHead;
    }

    public ListNode reverse(ListNode node) {
        if (node.next == null) {
            newHead = node;
        } else {
            ListNode temp = reverse(node.next);
            temp.next = node;
        }
        return node;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        LinkedListUtils.printLinkedList(new ReverseLinkedList().reverseList(LinkedListUtils.createLinkedList(arr)));
    }
}
