import java.util.*;

import java.util.*;

/**
 * LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Problem: Given two integer arrays preorder and inorder where:
 * - preorder is the preorder traversal of a binary tree
 * - inorder is the inorder traversal of the same tree
 * Construct and return the binary tree.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ConstructBinaryTreeFromPreorderInorder {
    
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }
    
    private static TreeNode build(int[] preorder, int preStart, int preEnd, 
                                   int[] inorder, int inStart, int inEnd, 
                                   Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inorderMap.get(preorder[preStart]);
        int numsLeft = inRoot - inStart;
        
        root.left = build(preorder, preStart + 1, preStart + numsLeft, 
                         inorder, inStart, inRoot - 1, inorderMap);
        root.right = build(preorder, preStart + numsLeft + 1, preEnd, 
                          inorder, inRoot + 1, inEnd, inorderMap);
        
        return root;
    }
    
    public static void main(String[] args) {
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode result1 = buildTree(preorder1, inorder1);
        System.out.println("Test 1 - preorder=[3,9,20,15,7], inorder=[9,3,15,20,7]");
        System.out.println("Output: " + TreeNode.treeToArray(result1));
        System.out.println("Expected: [3,9,20,null,null,15,7]");
        System.out.println("Pass: " + (result1.val == 3 && result1.left.val == 9) + "\n");
        
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode result2 = buildTree(preorder2, inorder2);
        System.out.println("Test 2 - preorder=[-1], inorder=[-1]");
        System.out.println("Output: " + TreeNode.treeToArray(result2));
        System.out.println("Expected: [-1]");
        System.out.println("Pass: " + (result2.val == -1) + "\n");
        
        int[] preorder3 = {1, 2};
        int[] inorder3 = {2, 1};
        TreeNode result3 = buildTree(preorder3, inorder3);
        System.out.println("Test 3 - preorder=[1,2], inorder=[2,1]");
        System.out.println("Output: " + TreeNode.treeToArray(result3));
        System.out.println("Expected: [1,2]");
        System.out.println("Pass: " + (result3.val == 1 && result3.left.val == 2) + "\n");
    }
}
