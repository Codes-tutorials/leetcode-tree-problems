import java.util.*;

import java.util.*;

/**
 * LeetCode 230: Kth Smallest Element in a BST
 * 
 * Problem: Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class KthSmallestElementInBST {
    
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return values.get(k - 1);
    }
    
    private static void inorder(TreeNode node, List<Integer> values) {
        if (node == null) return;
        
        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{3, 1, 4, null, 2});
        int result1 = kthSmallest(root1, 1);
        System.out.println("Test 1 - tree=[3,1,4,null,2], k=1");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 1");
        System.out.println("Pass: " + (result1 == 1) + "\n");
        
        TreeNode root2 = TreeNode.createTree(new Integer[]{3, 1, 4, null, 2});
        int result2 = kthSmallest(root2, 1);
        System.out.println("Test 2 - tree=[3,1,4,null,2], k=1");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 1");
        System.out.println("Pass: " + (result2 == 1) + "\n");
        
        TreeNode root3 = TreeNode.createTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        int result3 = kthSmallest(root3, 3);
        System.out.println("Test 3 - tree=[5,3,6,2,4,null,null,1], k=3");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 3");
        System.out.println("Pass: " + (result3 == 3) + "\n");
    }
}
