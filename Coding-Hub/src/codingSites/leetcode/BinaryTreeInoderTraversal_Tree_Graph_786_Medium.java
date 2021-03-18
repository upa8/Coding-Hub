package codingSites.leetcode;

import java.util.*;

// problem link -  https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/786/
// solution link - https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/

public class BinaryTreeInoderTraversal_Tree_Graph_786_Medium {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        
        if(root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode current = root;
        
        while(current != null || stack.size() >0) {
            // reach the last left element
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // pull the last element of the left side
            current = stack.pop();
            result.add(current.val);
            
            // now put the right most element
            current = current.right;
        }
        
        return result;
        
    }
}
