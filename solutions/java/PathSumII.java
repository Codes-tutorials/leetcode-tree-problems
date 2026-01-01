import java.util.*;

/**
 * LeetCode 113: Path Sum II
 * 
 * Problem: Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class PathSumII {
    
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, result);
        return result;
    }
    
    private static void dfs(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;
        
        path.add(node.val);
        
        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(path));
        } else {
            dfs(node.left, targetSum - node.val, path, result);
            dfs(node.right, targetSum - node.val, path, result);
        }
        
        path.remove(path.size() - 1);
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, 1});
        List<List<Integer>> result1 = pathSum(root1, 22);
        System.out.println("Test 1 - tree=[5,4,8,11,null,13,4,7,2,null,1], target=22");
        System.out.println("Output: " + result1);
        System.out.println("Expected: [[5,4,11,2]]");
        System.out.println("Pass: " + (result1.size() == 1) + "\n");
        
        TreeNode root2 = TreeNode.createTree(new Integer[]{1, 2, 3});
        List<List<Integer>> result2 = pathSum(root2, 5);
        System.out.println("Test 2 - tree=[1,2,3], target=5");
        System.out.println("Output: " + result2);
        System.out.println("Expected: []");
        System.out.println("Pass: " + (result2.size() == 0) + "\n");
        
        TreeNode root3 = TreeNode.createTree(new Integer[]{1, 2});
        List<List<Integer>> result3 = pathSum(root3, 3);
        System.out.println("Test 3 - tree=[1,2], target=3");
        System.out.println("Output: " + result3);
        System.out.println("Expected: [[1,2]]");
        System.out.println("Pass: " + (result3.size() == 1) + "\n");
    }
}
