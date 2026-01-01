/**
 * LeetCode 98: Validate Binary Search Tree
 * 
 * Problem: Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 * 
 * Constraints:
 * - The number of nodes in the tree is in the range [1, 10^4]
 * - -2^31 <= Node.val <= 2^31 - 1
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class ValidateBinarySearchTree {
    
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        
        if (node.val <= min || node.val >= max) return false;
        
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
    
    public static void main(String[] args) {
        // Test case 1: Valid BST
        TreeNode root1 = TreeNode.createTree(new Integer[]{2, 1, 3});
        boolean result1 = isValidBST(root1);
        System.out.println("Test 1 - tree=[2,1,3]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: true");
        System.out.println("Pass: " + (result1 == true) + "\n");
        
        // Test case 2: Invalid BST
        TreeNode root2 = TreeNode.createTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        boolean result2 = isValidBST(root2);
        System.out.println("Test 2 - tree=[5,1,4,null,null,3,6]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: false");
        System.out.println("Pass: " + (result2 == false) + "\n");
        
        // Test case 3: Single node
        TreeNode root3 = TreeNode.createTree(new Integer[]{1});
        boolean result3 = isValidBST(root3);
        System.out.println("Test 3 - tree=[1]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: true");
        System.out.println("Pass: " + (result3 == true) + "\n");
    }
}
