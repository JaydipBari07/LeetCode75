import java.sql.SQLOutput;

public class LinkedListUtils {

    public static ListNode createLinkedList(int[] arr) {
        ListNode listNode = new ListNode(arr[0]);
        ListNode cur = listNode;
        int i = 0;
        for (; i < arr.length - 1; i++) {
            cur.val = arr[i];
            cur.next = new ListNode();
            cur = cur.next;
        }
        cur.val = arr[i];
        return listNode;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
