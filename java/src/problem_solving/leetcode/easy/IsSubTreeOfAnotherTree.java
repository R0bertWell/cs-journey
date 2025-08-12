package problem_solving.leetcode.easy;

import problem_solving.TreeNode;

public class IsSubTreeOfAnotherTree {
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if(isSameTree(root, subRoot)){
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val == subRoot.val) return true;

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}
