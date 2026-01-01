/**
 * LeetCode 404: Sum of Left Leaves
 * 
 * Problem: Given the root of a binary tree, return the sum of all left leaves.
 * A left leaf is a leaf node which is the left child of its parent node.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class SumOfLeftLeaves {
    
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        int result1 = sumOfLeftLeaves(root1);
        System.out.println("Test 1 - tree=[3,9,20,null,null,15,7]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 24");
        System.out.println("Pass: " + (result1 == 24) + "\n");
        
        TreeNode root2 = TreeNode.createTree(new Integer[]{1});
        int result2 = sumOfLeftLeaves(root2);
        System.out.println("Test 2 - tree=[1]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 0");
        System.out.println("Pass: " + (result2 == 0) + "\n");
        
        TreeNode root3 = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5});
        int result3 = sumOfLeftLeaves(root3);
        System.out.println("Test 3 - tree=[1,2,3,4,5]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 4");
        System.out.println("Pass: " + (result3 == 4) + "\n");
    }
}
