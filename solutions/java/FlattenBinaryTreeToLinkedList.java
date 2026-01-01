/**
 * LeetCode 114: Flatten Binary Tree to Linked List
 * 
 * Problem: Given the root of a binary tree, flatten the tree into a "linked list":
 * - The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * - The "linked list" should be in pre-order traversal order.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class FlattenBinaryTreeToLinkedList {
    
    private static TreeNode prev = null;
    
    public static void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        prev = null;
        flatten(root1);
        System.out.println("Test 1 - tree=[1,2,5,3,4,null,6]");
        System.out.println("Output: " + TreeNode.treeToArray(root1));
        System.out.println("Expected: [1,null,2,null,3,null,4,null,5,null,6]");
        System.out.println("Pass: " + (root1.left == null && root1.right != null) + "\n");
        
        TreeNode root2 = TreeNode.createTree(new Integer[]{});
        prev = null;
        flatten(root2);
        System.out.println("Test 2 - tree=[]");
        System.out.println("Output: " + TreeNode.treeToArray(root2));
        System.out.println("Expected: []");
        System.out.println("Pass: " + (root2 == null) + "\n");
        
        TreeNode root3 = TreeNode.createTree(new Integer[]{0});
        prev = null;
        flatten(root3);
        System.out.println("Test 3 - tree=[0]");
        System.out.println("Output: " + TreeNode.treeToArray(root3));
        System.out.println("Expected: [0]");
        System.out.println("Pass: " + (root3.left == null && root3.right == null) + "\n");
    }
}
