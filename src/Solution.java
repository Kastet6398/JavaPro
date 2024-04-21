public class Solution {
    public static void reverseList(ListNode head) {
        reverseList(head, null);
    }

    private static ListNode reverseList(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        }

        ListNode res = reverseList(head.getNext(), head);
        head.setNext(prev);
        return res;
    }
}
