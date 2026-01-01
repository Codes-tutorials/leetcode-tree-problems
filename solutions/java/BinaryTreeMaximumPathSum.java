/**
 * LeetCode 124: Binary Tree Maximum Path Sum
 * 
 * Problem: A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * Return the maximum path sum of any non-empty path.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class BinaryTreeMaximumPathSum {
    
    private static int maxSum = Integer.MIN_VALUE;
    
    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
    
    private static int dfs(TreeNode node) {
        if (node == null) return 0;
        
        int leftSum = Math.max(0, dfs(node.left));
        int rightSum = Math.max(0, dfs(node.right));
        
        maxSum = Math.max(maxSum, node.val + leftSum + rightSum);
        
        return node.val + Math.max(leftSum, rightSum);
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{1, 2, 3});
        int result1 = maxPathSum(root1);
        System.out.println("Test 1 - tree=[1,2,3]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 6");
        System.out.println("Pass: " + (result1 == 6) + "\n");
        
        TreeNode root2 = TreeNode.createTree(new Integer[]{-10, 9, 20, null, null, 15, 7});
        int result2 = maxPathSum(root2);
        System.out.println("Test 2 - tree=[-10,9,20,null,null,15,7]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 42");
        System.out.println("Pass: " + (result2 == 42) + "\n");
        
        TreeNode root3 = TreeNode.createTree(new Integer[]{-3});
        int result3 = maxPathSum(root3);
        System.out.println("Test 3 - tree=[-3]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: -3");
        System.out.println("Pass: " + (result3 == -3) + "\n");
    }
}
