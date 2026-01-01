/**
 * LeetCode 226: Invert Binary Tree
 * 
 * Problem: Given the root of a binary tree, invert the tree, and return its root.
 * 
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 100]
 * - -100 <= Node.val <= 100
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class InvertBinaryTree {
    
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
    
    public static void main(String[] args) {
        // Test case 1: Normal tree
        TreeNode root1 = TreeNode.createTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode result1 = invertTree(root1);
        Integer[] arr1 = TreeNode.treeToArray(result1);
        System.out.println("Test 1 - tree=[4,2,7,1,3,6,9]");
        System.out.println("Output: " + java.util.Arrays.toString(arr1));
        System.out.println("Expected: [4, 7, 2, 9, 6, 3, 1]");
        System.out.println("Pass: " + java.util.Arrays.equals(arr1, new Integer[]{4, 7, 2, 9, 6, 3, 1}) + "\n");
        
        // Test case 2: Single node
        TreeNode root2 = TreeNode.createTree(new Integer[]{1});
        TreeNode result2 = invertTree(root2);
        Integer[] arr2 = TreeNode.treeToArray(result2);
        System.out.println("Test 2 - tree=[1]");
        System.out.println("Output: " + java.util.Arrays.toString(arr2));
        System.out.println("Expected: [1]");
        System.out.println("Pass: " + java.util.Arrays.equals(arr2, new Integer[]{1}) + "\n");
        
        // Test case 3: Empty tree
        TreeNode root3 = null;
        TreeNode result3 = invertTree(root3);
        System.out.println("Test 3 - tree=[]");
        System.out.println("Output: " + (result3 == null ? "null" : "not null"));
        System.out.println("Expected: null");
        System.out.println("Pass: " + (result3 == null) + "\n");
    }
}
