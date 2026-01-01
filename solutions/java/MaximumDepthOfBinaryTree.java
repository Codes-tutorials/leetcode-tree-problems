/**
 * LeetCode 104: Maximum Depth of Binary Tree
 * 
 * Problem: Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 10^4]
 * - -100 <= Node.val <= 100
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is height
 */
public class MaximumDepthOfBinaryTree {
    
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    public static void main(String[] args) {
        // Test case 1: Balanced tree
        TreeNode root1 = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        int result1 = maxDepth(root1);
        System.out.println("Test 1 - tree=[3,9,20,null,null,15,7]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 3");
        System.out.println("Pass: " + (result1 == 3) + "\n");
        
        // Test case 2: Single node
        TreeNode root2 = TreeNode.createTree(new Integer[]{1});
        int result2 = maxDepth(root2);
        System.out.println("Test 2 - tree=[1]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 1");
        System.out.println("Pass: " + (result2 == 1) + "\n");
        
        // Test case 3: Empty tree
        TreeNode root3 = null;
        int result3 = maxDepth(root3);
        System.out.println("Test 3 - tree=[]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 0");
        System.out.println("Pass: " + (result3 == 0) + "\n");
    }
}
