/**
 * LeetCode 235: Lowest Common Ancestor of a Binary Search Tree
 * 
 * Problem: Given a binary search tree (BST) of unique values, and two nodes from the tree p and q,
 * return the lowest common ancestor (LCA) of the two nodes.
 * 
 * Time Complexity: O(log n) average, O(n) worst
 * Space Complexity: O(1)
 */
public class LowestCommonAncestorBST {
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p1 = root1.left;
        TreeNode q1 = root1.right;
        TreeNode result1 = lowestCommonAncestor(root1, p1, q1);
        System.out.println("Test 1 - tree=[6,2,8,0,4,7,9,null,null,3,5], p=2, q=8");
        System.out.println("Output: " + result1.val);
        System.out.println("Expected: 6");
        System.out.println("Pass: " + (result1.val == 6) + "\n");
        
        TreeNode root2 = TreeNode.createTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p2 = root2.left;
        TreeNode q2 = root2.left.right;
        TreeNode result2 = lowestCommonAncestor(root2, p2, q2);
        System.out.println("Test 2 - tree=[6,2,8,0,4,7,9,null,null,3,5], p=2, q=4");
        System.out.println("Output: " + result2.val);
        System.out.println("Expected: 2");
        System.out.println("Pass: " + (result2.val == 2) + "\n");
        
        TreeNode root3 = TreeNode.createTree(new Integer[]{2, 1});
        TreeNode p3 = root3;
        TreeNode q3 = root3.left;
        TreeNode result3 = lowestCommonAncestor(root3, p3, q3);
        System.out.println("Test 3 - tree=[2,1], p=2, q=1");
        System.out.println("Output: " + result3.val);
        System.out.println("Expected: 2");
        System.out.println("Pass: " + (result3.val == 2) + "\n");
    }
}
