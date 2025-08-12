package problem_solving.leetcode.easy;



class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public static ListNode reverseList(ListNode head) {
        ListNode reversed = new ListNode(0);
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null){
            reversed.next = new ListNode(temp.val, prev);
            prev = reversed.next;

            temp = temp.next;
        }

        return reversed.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        reverseList(head);
    }
}