package problem_solving.interview;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {


    public static class Node{
        int value;
        Node left, right;
        String name;

        public Node(int value, String name){
            this.value = value;
            this.name = name;
            this.left = null;
            this.right = null;
        }

        public String toString(){
            return this.name + "(" + this.value +")";
        }
    }


    public static Node findHighestValue(Node node){
        Queue<Node> nodeQueue = new LinkedList<>();
        Node highest = node;
        nodeQueue.add(node);
        while(!nodeQueue.isEmpty()){
            Node current = nodeQueue.poll();

            if(current.value > highest.value) highest = current;

            if(current.left != null) nodeQueue.add(current.left);

            if(current.right != null)nodeQueue.add(current.right);

        }

        return highest;
    }

    public static void main(String[] args) {
        Node N1 = new Node(15, "N1");
        Node N2 = new Node(8, "N2");
        Node N3 = new Node(16, "N3");
        Node N4 = new Node(6, "N4");
        Node N5 = new Node(2, "N5");
        Node N6 = new Node(3, "N6");
        Node N7 = new Node(12, "N7");
        Node N8 = new Node(23, "N8");
        Node N9 = new Node(3, "N9");
        Node N10 = new Node(42, "N10");
        Node N11 = new Node(6, "N11");
        Node N12 = new Node(35, "N12");
        Node N13 = new Node(26, "N13");
        Node N15 = new Node(51, "N15");
        Node N16 = new Node(8, "N16");

        N1.left = N2;
        N1.right = N3;

        N2.left = N4;
        N4.left = N7;
        N4.right = N8;

        N7.left = N11;
        N8.right = N12;

        N3.left = N5;
        N3.right = N6;

        N5.left = N9;
        N9.left = N13;

        N6.right = N10;
        N10.left = N15;
        N10.right = N16;

        System.out.println(findHighestValue(N15));
        System.out.println(findHighestValue(N12));
        System.out.println(findHighestValue(N13));

    }
}
