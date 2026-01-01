/**
 * LeetCode 110: Balanced Binary Tree
 * 
 * Problem: Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees
 * of every node never differs by more than one.
 * 
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 5000]
 * - -10^4 <= Node.val <= 10^4
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class BalancedBinaryTree {
    
    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    
    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) return -1;
        
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public static void main(String[] args) {
        // Test case 1: Balanced tree
        TreeNode root1 = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        boolean result1 = isBalanced(root1);
        System.out.println("Test 1 - tree=[3,9,20,null,null,15,7]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: true");
        System.out.println("Pass: " + (result1 == true) + "\n");
        
        // Test case 2: Unbalanced tree
        TreeNode root2 = TreeNode.createTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4});
        boolean result2 = isBalanced(root2);
        System.out.println("Test 2 - tree=[1,2,2,3,3,null,null,4,4]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: false");
        System.out.println("Pass: " + (result2 == false) + "\n");
        
        // Test case 3: Single node
        TreeNode root3 = TreeNode.createTree(new Integer[]{1});
        boolean result3 = isBalanced(root3);
        System.out.println("Test 3 - tree=[1]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: true");
        System.out.println("Pass: " + (result3 == true) + "\n");
    }
}
