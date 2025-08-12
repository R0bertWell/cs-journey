package problem_solving.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CopyListWithRandomPointer {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Node dummy = head;
        Node coppy = new Node(0);
        Node temp = coppy;
        HashMap<Node, Node> randomRef = new HashMap<>();
        while(dummy != null){
            Node cur = new Node(dummy.val);
            cur.random = dummy.random;
            temp.next = cur;
            temp = temp.next;

            randomRef.put(dummy, cur);
            dummy = dummy.next;
        }

        temp = coppy.next;

        while(temp != null){
            if(temp.random != null) {
                temp.random = randomRef.get(temp.random);
            }

            temp = temp.next;
        }

        return coppy.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        Node node = new Node(7);
        node.random = null;
        node.next = node1;
        node1.random = node;
        node1.next = node2;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;
        node4.next = null;
        node4.random = node;

        copyRandomList(node);
    }
}
