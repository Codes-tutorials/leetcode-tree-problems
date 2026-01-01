/**
 * LeetCode 94: Binary Tree Inorder Traversal
 * 
 * Problem: Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Inorder: Left -> Root -> Right
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
import java.util.*;

public class BinaryTreeInorderTraversal {
    
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    
    private static void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{1, null, 2});
        List<Integer> result1 = inorderTraversal(root1);
        System.out.println("Test 1 - tree=[1,null,2]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: [1, 2]");
        System.out.println("Pass: " + result1.equals(Arrays.asList(1, 2)) + "\n");
        
        TreeNode root2 = null;
        List<Integer> result2 = inorderTraversal(root2);
        System.out.println("Test 2 - tree=[]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: []");
        System.out.println("Pass: " + result2.isEmpty() + "\n");
        
        TreeNode root3 = TreeNode.createTree(new Integer[]{1});
        List<Integer> result3 = inorderTraversal(root3);
        System.out.println("Test 3 - tree=[1]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: [1]");
        System.out.println("Pass: " + result3.equals(Arrays.asList(1)) + "\n");
    }
}
