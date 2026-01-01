/**
 * LeetCode 102: Binary Tree Level Order Traversal
 * 
 * Problem: Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(w) where w is max width
 */
import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(level);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> result1 = levelOrder(root1);
        System.out.println("Test 1 - tree=[3,9,20,null,null,15,7]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: [[3], [9, 20], [15, 7]]");
        System.out.println("Pass: " + result1.equals(Arrays.asList(
            Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7))) + "\n");
        
        TreeNode root2 = TreeNode.createTree(new Integer[]{1});
        List<List<Integer>> result2 = levelOrder(root2);
        System.out.println("Test 2 - tree=[1]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: [[1]]");
        System.out.println("Pass: " + result2.equals(Arrays.asList(Arrays.asList(1))) + "\n");
        
        TreeNode root3 = null;
        List<List<Integer>> result3 = levelOrder(root3);
        System.out.println("Test 3 - tree=[]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: []");
        System.out.println("Pass: " + result3.isEmpty() + "\n");
    }
}
