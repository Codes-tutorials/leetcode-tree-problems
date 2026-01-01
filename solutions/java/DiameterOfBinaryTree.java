/**
 * LeetCode 543: Diameter of Binary Tree
 * 
 * Problem: Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class DiameterOfBinaryTree {
    
    private static int diameter = 0;
    
    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        getHeight(root);
        return diameter;
    }
    
    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        diameter = Math.max(diameter, leftHeight + rightHeight);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5});
        int result1 = diameterOfBinaryTree(root1);
        System.out.println("Test 1 - tree=[1,2,3,4,5]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 3");
        System.out.println("Pass: " + (result1 == 3) + "\n");
        
        TreeNode root2 = TreeNode.createTree(new Integer[]{1, 2});
        int result2 = diameterOfBinaryTree(root2);
        System.out.println("Test 2 - tree=[1,2]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 1");
        System.out.println("Pass: " + (result2 == 1) + "\n");
        
        TreeNode root3 = TreeNode.createTree(new Integer[]{1});
        int result3 = diameterOfBinaryTree(root3);
        System.out.println("Test 3 - tree=[1]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 0");
        System.out.println("Pass: " + (result3 == 0) + "\n");
    }
}
