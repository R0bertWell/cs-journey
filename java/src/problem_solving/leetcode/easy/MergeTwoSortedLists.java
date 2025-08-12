package problem_solving.leetcode.easy;

public class MergeTwoSortedLists {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current = new ListNode(0);
        ListNode mergedList = current;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            } else if(list2.val < list1.val){
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                current.next = new ListNode(list1.val);
                current = current.next;
                current.next = new ListNode(list2.val);
                list1 = list1.next;
                list2 = list2.next;
            }
            current = current.next;
        }

        while(list1 != null){
            current.next = new ListNode(list1.val);
            current = current.next;
            list1 = list1.next;
        }

        while(list2 != null){
            current.next = new ListNode(list2.val);
            current = current.next;
            list2 = list2.next;
        }

        return mergedList.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        mergeTwoLists(listNode1, listNode2);
    }
}
