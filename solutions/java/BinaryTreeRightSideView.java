import java.util.*;

import java.util.*;

/**
 * LeetCode 199: Binary Tree Right Side View
 * 
 * Problem: Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class BinaryTreeRightSideView {
    
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{1, 2, 3, null, 5, null, 4});
        List<Integer> result1 = rightSideView(root1);
        System.out.println("Test 1 - tree=[1,2,3,null,5,null,4]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: [1,3,4]");
        System.out.println("Pass: " + (result1.equals(Arrays.asList(1, 3, 4))) + "\n");
        
        TreeNode root2 = TreeNode.createTree(new Integer[]{1, null, 3});
        List<Integer> result2 = rightSideView(root2);
        System.out.println("Test 2 - tree=[1,null,3]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: [1,3]");
        System.out.println("Pass: " + (result2.equals(Arrays.asList(1, 3))) + "\n");
        
        TreeNode root3 = TreeNode.createTree(new Integer[]{1, 2, 3, 4});
        List<Integer> result3 = rightSideView(root3);
        System.out.println("Test 3 - tree=[1,2,3,4]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: [1,3,4]");
        System.out.println("Pass: " + (result3.equals(Arrays.asList(1, 3, 4))) + "\n");
    }
}
