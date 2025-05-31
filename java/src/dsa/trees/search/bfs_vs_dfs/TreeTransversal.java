package dsa.trees.search.bfs_vs_dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeTransversal {

    public static List<Integer> bfs(BinarySearchTree binarySearchTree) {
        List<Integer> data = new ArrayList<>();
        BinarySearchTree.Node current = binarySearchTree.root;
        Queue<BinarySearchTree.Node> queue = new ArrayDeque<>();
        queue.add(current);

        while(!queue.isEmpty()){
            current = queue.remove();
            data.add(current.data);

            if(current.left != null){
                queue.add((current.left));
            }

            if(current.right != null){
                queue.add(current.right);
            }
        }

        return data;
    }

    public static List<Integer> dfsPreOrder(BinarySearchTree binarySearchTree) {
        ArrayList<Integer> data = new ArrayList<>();
        BinarySearchTree.Node current = binarySearchTree.root;
        return recursiveDfsPreOrder(current, data);
    }

    private static List<Integer> recursiveDfsPreOrder(BinarySearchTree.Node current, List<Integer> data) {
        if(current == null) return data;

        data.add(current.data);

        if(current.left != null) recursiveDfsPreOrder(current.left, data);
        if(current.right != null) recursiveDfsPreOrder(current.right, data);

        return data;
    }

    private static List<Integer> dfsPostOrder(BinarySearchTree binarySearchTree){
        List<Integer> data = new ArrayList<>();
        BinarySearchTree.Node current = binarySearchTree.root;
        return recursiveDfsPostOrder(current, data);
    }

    private static List<Integer> recursiveDfsPostOrder(BinarySearchTree.Node current, List<Integer> data){
        if (current == null) return data;

        if(current.left != null) recursiveDfsPostOrder(current.left, data);
        if(current.right != null) recursiveDfsPostOrder(current.right, data);
        data.add(current.data);


        return data;
    }

    private static List<Integer> dfsInOrder(BinarySearchTree binarySearchTree){
        List<Integer> data = new ArrayList<>();
        BinarySearchTree.Node current = binarySearchTree.root;
        return recursiveDfsPostOrder(current, data);
    }

    private static List<Integer> recursiveDfsInOrder(BinarySearchTree.Node current, List<Integer> data){
        if (current == null) return data;

        if(current.left != null) recursiveDfsPostOrder(current.left, data);
        data.add(current.data);
        if(current.right != null) recursiveDfsPostOrder(current.right, data);

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

//        bfs(binarySearchTree);
//        dfsPreOrder(binarySearchTree);
        dfsPostOrder(binarySearchTree);
    }
}
