/**
 * LeetCode 100: Same Tree
 * 
 * Problem: Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * 
 * Constraints:
 * - The number of nodes in each tree is in the range [0, 100]
 * - -10^4 <= Node.val <= 10^4
 * 
 * Time Complexity: O(min(n, m))
 * Space Complexity: O(min(h1, h2))
 */
public class SameTree {
    
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public static void main(String[] args) {
        // Test case 1: Same trees
        TreeNode p1 = TreeNode.createTree(new Integer[]{1, 2, 3});
        TreeNode q1 = TreeNode.createTree(new Integer[]{1, 2, 3});
        boolean result1 = isSameTree(p1, q1);
        System.out.println("Test 1 - p=[1,2,3], q=[1,2,3]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: true");
        System.out.println("Pass: " + (result1 == true) + "\n");
        
        // Test case 2: Different structure
        TreeNode p2 = TreeNode.createTree(new Integer[]{1, 2});
        TreeNode q2 = TreeNode.createTree(new Integer[]{1, null, 2});
        boolean result2 = isSameTree(p2, q2);
        System.out.println("Test 2 - p=[1,2], q=[1,null,2]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: false");
        System.out.println("Pass: " + (result2 == false) + "\n");
        
        // Test case 3: Different values
        TreeNode p3 = TreeNode.createTree(new Integer[]{1, 2, 1});
        TreeNode q3 = TreeNode.createTree(new Integer[]{1, 1, 2});
        boolean result3 = isSameTree(p3, q3);
        System.out.println("Test 3 - p=[1,2,1], q=[1,1,2]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: false");
        System.out.println("Pass: " + (result3 == false) + "\n");
    }
}
