package problem_solving.leetcode.medium;

import problem_solving.leetcode.easy.LinkedListCycle;

public class RemoveNthNodeFromEndOfList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;

        ListNode dummy = head, cur = head;

        int size = 0;
        while(cur != null){
            cur = cur.next;
            size++;
        }

        size -= n;
        while(size - 1 > 0){
            dummy = dummy.next;
            size--;
        }

        dummy.next = dummy.next.next;

        return head;
    }

    public static ListNode removeNthFromEndBetter(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode behind = dummy, ahead = dummy;

        for (int i = 0; i <= n; i++) {
            ahead = ahead.next;
        }

        while (ahead != null) {
            behind = behind.next;
            ahead = ahead.next;
        }

        behind.next = behind.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode ls2 = new ListNode(1);
        removeNthFromEndBetter(ls2, 1);
        ListNode ls = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        removeNthFromEnd(ls, 2);
        ListNode ls1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        removeNthFromEndBetter(ls1, 2);
    }
}