public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);

        head.setNext(ln2);
        ln2.setNext(ln3);
        ln3.setNext(ln4);
        ln4.setNext(ln5);

        Solution.reverseList(head);

        ListNode c = ln5;
        while (c != null) {
            System.out.println(c);
            c=c.getNext();
        }
    }
}