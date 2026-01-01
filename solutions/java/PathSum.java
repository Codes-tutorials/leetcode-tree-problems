/**
 * LeetCode 112: Path Sum
 * 
 * Problem: Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals targetSum.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class PathSum {
    
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        
        return hasPathSum(root.left, targetSum - root.val) || 
               hasPathSum(root.right, targetSum - root.val);
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, 1});
        boolean result1 = hasPathSum(root1, 22);
        System.out.println("Test 1 - tree=[5,4,8,11,null,13,4,7,2,null,1], target=22");
        System.out.println("Output: " + result1);
        System.out.println("Expected: true");
        System.out.println("Pass: " + (result1 == true) + "\n");
        
        TreeNode root2 = TreeNode.createTree(new Integer[]{1, 2, 3});
        boolean result2 = hasPathSum(root2, 5);
        System.out.println("Test 2 - tree=[1,2,3], target=5");
        System.out.println("Output: " + result2);
        System.out.println("Expected: false");
        System.out.println("Pass: " + (result2 == false) + "\n");
        
        TreeNode root3 = TreeNode.createTree(new Integer[]{1, 2});
        boolean result3 = hasPathSum(root3, 1);
        System.out.println("Test 3 - tree=[1,2], target=1");
        System.out.println("Output: " + result3);
        System.out.println("Expected: false");
        System.out.println("Pass: " + (result3 == false) + "\n");
    }
}
