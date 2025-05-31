package dsa.trees.search.bfs_vs_dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;


    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(int value){
        Node newNode = new Node(value);
        if(this.root == null) {
            this.root = newNode;
            return;
        }

        Node temp = this.root;
        while(true){
            if(newNode.data == temp.data) return;

            if(newNode.data < temp.data){
                if(temp.left == null){
                    temp.left = newNode;
                    return;
                }

                temp = temp.left;
            } else {
                if(temp.right == null){
                    temp.right = newNode;
                    return;
                }

                temp = temp.right;
            }
        }
//        this.verifyInsertion(temp, newNode);
    }

    private void verifyInsertion(Node node, Node newNode){
        if(node.data == newNode.data) return;

        if(newNode.data > node.data){
            if(node.right == null){
                node.right = newNode;
                return;
            }

            this.verifyInsertion(node.right, newNode);
        } else {
            if(node.left == null){
                node.left = newNode;
                return;
            }

            this.verifyInsertion(node.left, newNode);
        }
    }

    public boolean includes(int value){
        return this.search(value) != null;
    }

    public Integer search(int value){
        Node temp = this.root;
        while(temp != null){
            if(temp.data == value) return value;

            if(value < temp.data){
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        return null;
    }

    public ArrayList<Integer> bfs() {
        ArrayList<Integer> data = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        Node current = this.root;

        queue.add(current);

        while(queue.size() != 0){
            current = queue.remove();
            data.add(current.data);

            if(current.left != null){
                queue.add(current.left);
            }

            if(current.right != null){
                queue.add(current.right);
            }
        }

        return data;
    }

    public ArrayList<Integer> dfsPreOrder(){
        ArrayList<Integer> data = new ArrayList<>();
        Node current = this.root;
        return recursiveDfs(current, data);
    }

    public ArrayList<Integer> recursiveDfs(Node current, ArrayList<Integer> data){
        if(current == null) return null;

        data.add(current.data);

        if (current.left != null ) recursiveDfs(current.left, data);
        if (current.right != null ) recursiveDfs(current.right, data);

        return data;
    }

    public ArrayList<Integer> dfsPostOrder(){
        ArrayList<Integer> data = new ArrayList<>();
        Node current = this.root;
        return dfsPostOrderRecursive(current, data);
    }

    public ArrayList<Integer> dfsPostOrderRecursive(Node current, ArrayList<Integer> data){
        if(current == null) return null;

        if(current.left != null) dfsPostOrderRecursive(current.left, data);
        if(current.right != null) dfsPostOrderRecursive(current.right, data);

        data.add(current.data);

        return data;
    }

    public ArrayList<Integer> dfsInOrder(){
        ArrayList<Integer> data = new ArrayList<>();
        Node current = this.root;

        return dfsInOrderRecursive(current, data);
    }

    public ArrayList<Integer> dfsInOrderRecursive(Node current, ArrayList<Integer> data){
        if(current == null) return null;

        if(current.left != null){
            dfsInOrderRecursive(current.left, data);
        }

        data.add(current.data);

        if(current.right != null){
            dfsInOrderRecursive(current.right, data);
        }

        return data;
    }

    public ArrayList<Integer> dfsReverseOrder(){
        ArrayList<Integer> data = new ArrayList<>();
        Node current = this.root;

        return dfsReserveOrderRecursive(current, data);
    }

    public ArrayList<Integer> dfsReserveOrderRecursive(Node current, ArrayList<Integer> data){
        if(current == null) return null;

        if(current.right != null){
            dfsReserveOrderRecursive(current.right, data);
        }

        data.add(current.data);

        if(current.left != null){
            dfsReserveOrderRecursive(current.left, data);
        }

        return data;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(10);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(0);
        binarySearchTree.insert(50);
        binarySearchTree.insert(60);
        binarySearchTree.insert(70);
        binarySearchTree.insert(9);
        binarySearchTree.insert(8);
        binarySearchTree.insert(8);
        binarySearchTree.insert(8);
        binarySearchTree.insert(8);
        System.out.println(binarySearchTree.search(0));
        System.out.println(binarySearchTree.search(100));
        System.out.println(binarySearchTree.search(70));
        System.out.println(binarySearchTree.search(60));
        System.out.println(binarySearchTree.includes(0));
        System.out.println(binarySearchTree.includes(100));
        System.out.println(binarySearchTree.includes(70));
        System.out.println(binarySearchTree.includes(60));

        System.out.println("BFS, Level order : " + binarySearchTree.bfs());
        System.out.println("PreOrder :" + binarySearchTree.dfsPreOrder());
        System.out.println("PostOrder :"  + binarySearchTree.dfsPostOrder());
        System.out.println("InOrder :" + binarySearchTree.dfsInOrder());
        System.out.println("ReverseOrder :" + binarySearchTree.dfsReverseOrder());

    }
}
