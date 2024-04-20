public class Main {
    public static void main(String[] args) {
        ListNode ln5 = new ListNode(5);
        ListNode ln4 = new ListNode(4, ln5);
        ListNode ln3 = new ListNode(3, ln4);
        ListNode ln2 = new ListNode(2, ln3);
        ListNode head = new ListNode(1, ln2);

        Solution.reverseList(head);

        ListNode c = ln5;
        while (c != null) {
            System.out.println(c);
            c=c.getNext();
        }
    }
}