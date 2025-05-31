package dsa.trees;

public class BinaryTree {

    TreeNode root;

    public BinaryTree(){
        this.root = null;
    }

    public TreeNode insert(int value){
        if(root == null) {
            this.root = new TreeNode(value);
            return this.root;
        }

        TreeNode currNode = root;
        TreeNode newNode = new TreeNode(value);

        while(true){
            int currValue = currNode.data;

            if(currValue == value) break;

            if(value < currValue){
                if(currNode.left == null){
                    currNode.left = newNode;
                    break;
                }
                currNode = currNode.left;
            } else {
                if(currNode.right == null){
                    currNode.right = newNode;
                    break;
                }
                currNode = currNode.right;
            }
        }

        return root;
    }

    public static int findSumRecursive(TreeNode root){
        if(root == null) return 0;

        return root.data + findSumRecursive(root.left) + findSumRecursive(root.right);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(8);
        binaryTree.insert(8);
        binaryTree.insert(8);
        binaryTree.insert(8);
        binaryTree.insert(8);
        binaryTree.insert(8);
        binaryTree.insert(8);
        binaryTree.insert(8);
        binaryTree.insert(8);
        binaryTree.insert(8);

        binaryTree.insert(2);
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(9);
        binaryTree.insert(15);

        TreeNode nullTreeNode = null;

        System.out.println("Sum NULL NODE=> " + findSumRecursive(nullTreeNode));
        System.out.println("Sum => " + findSumRecursive(binaryTree.root));

    }
}
