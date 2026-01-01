import java.util.*;

import java.util.*;

/**
 * LeetCode 297: Serialize and Deserialize Binary Tree
 * 
 * Problem: Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SerializeAndDeserializeBinaryTree {
    
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private static void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }
    
    public static TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return deserializeHelper(queue);
    }
    
    private static TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        
        if (val.equals("null")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        
        return node;
    }
    
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.createTree(new Integer[]{1, 2, 3, null, null, 4, 5});
        String serialized1 = serialize(root1);
        TreeNode deserialized1 = deserialize(serialized1);
        System.out.println("Test 1 - tree=[1,2,3,null,null,4,5]");
        System.out.println("Serialized: " + serialized1);
        System.out.println("Deserialized: " + TreeNode.treeToArray(deserialized1));
        System.out.println("Pass: " + TreeNode.isEqual(root1, deserialized1) + "\n");
        
        TreeNode root2 = TreeNode.createTree(new Integer[]{});
        String serialized2 = serialize(root2);
        TreeNode deserialized2 = deserialize(serialized2);
        System.out.println("Test 2 - tree=[]");
        System.out.println("Serialized: " + serialized2);
        System.out.println("Deserialized: " + TreeNode.treeToArray(deserialized2));
        System.out.println("Pass: " + (deserialized2 == null) + "\n");
        
        TreeNode root3 = TreeNode.createTree(new Integer[]{1});
        String serialized3 = serialize(root3);
        TreeNode deserialized3 = deserialize(serialized3);
        System.out.println("Test 3 - tree=[1]");
        System.out.println("Serialized: " + serialized3);
        System.out.println("Deserialized: " + TreeNode.treeToArray(deserialized3));
        System.out.println("Pass: " + TreeNode.isEqual(root3, deserialized3) + "\n");
    }
}
