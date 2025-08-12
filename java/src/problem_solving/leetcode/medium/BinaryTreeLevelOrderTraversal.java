package problem_solving.leetcode.medium;

import problem_solving.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return List.of();

        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tempQueue;

        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> curList = new ArrayList<>();
            tempQueue = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode curNode = queue.poll();
                curList.add(curNode.val);
                if(curNode.left != null) tempQueue.add(curNode.left);
                if(curNode.right != null) tempQueue.add(curNode.right);
            }
            answer.add(curList);
            queue = tempQueue; // teste
        }

        return answer;
    }
}
