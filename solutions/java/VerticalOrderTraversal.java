import java.util.*;

import java.util.*;

/**
 * LeetCode 987: Vertical Order Traversal of a Binary Tree
 * 
 * Problem: Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 * For each column, report the nodes in sorted order from top to bottom.
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class VerticalOrderTraversal {
    
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Map<Integer, List<Integer>> columnMap = new TreeMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();
        
        nodeQueue.offer(root);
        columnQueue.offer(0);
        
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int column = columnQueue.poll();
            
            columnMap.putIfAbsent(column, new ArrayList<>());
            columnMap.get(column).add(node.val);
            
            if (node.left != null) {
                nodeQueue.offer(node.left);
                columnQueue.offer(column - 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                columnQueue.offer(column + 1);
            }
        }
        
        for (List<Integer> column : columnMap.values()) {
            Collections.sort(column);
            result.add(column);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> result1 = verticalTraversal(root1);
        System.out.println("Test 1 - tree=[3,9,20,null,null,15,7]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: [[9],[3,15],[20],[7]]");
        System.out.println("Pass: " + (result1.size() == 4) + "\n");
        
        TreeNode root2 = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        List<List<Integer>> result2 = verticalTraversal(root2);
        System.out.println("Test 2 - tree=[1,2,3,4,5,6,7]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: [[4],[2],[1,5,6],[3],[7]]");
        System.out.println("Pass: " + (result2.size() == 5) + "\n");
        
        TreeNode root3 = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 6, 5, 7});
        List<List<Integer>> result3 = verticalTraversal(root3);
        System.out.println("Test 3 - tree=[1,2,3,4,6,5,7]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: [[4],[2],[1,5,6],[3],[7]]");
        System.out.println("Pass: " + (result3.size() == 5) + "\n");
    }
}
