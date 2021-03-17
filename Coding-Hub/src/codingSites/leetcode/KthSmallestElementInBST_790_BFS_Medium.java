package codingSites.leetcode;

import java.util.*;

// problem link - https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/790/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class KthSmallestElementInBST_790_BFS_Medium {
    public int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return 0;
        }

        PriorityQueue<TreeNode> qu = new PriorityQueue<TreeNode>((n2, n1) -> n2.val - n1.val);

        Queue<TreeNode> bfsQueue = new LinkedList<TreeNode>();

        bfsQueue.add(root);

        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for (int index = 0; index < size; index++) {
                TreeNode node = bfsQueue.poll();

                qu.add(node);

                if (node.right != null) {
                    bfsQueue.add(node.right);
                }

                if (node.left != null) {
                    bfsQueue.add(node.left);
                }
            }
        }

        for (int index = 0; index < k - 1; index++) {
            TreeNode node = qu.poll();
        }
        return qu.peek().val;
    }
}
