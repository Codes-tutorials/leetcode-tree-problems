import java.util.*;

import java.util.*;

/**
 * LeetCode 116: Populating Next Right Pointers in Each Node
 * 
 * Problem: You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class PopulatingNextRightPointers {
    
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    public static Node connect(Node root) {
        if (root == null) return null;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        
        connect(root1);
        System.out.println("Test 1 - tree=[1,2,3,4,5,6,7]");
        System.out.println("Output: root.left.next.val = " + root1.left.next.val);
        System.out.println("Expected: 3");
        System.out.println("Pass: " + (root1.left.next.val == 3) + "\n");
        
        Node root2 = new Node(1);
        connect(root2);
        System.out.println("Test 2 - tree=[1]");
        System.out.println("Output: root.next = " + root2.next);
        System.out.println("Expected: null");
        System.out.println("Pass: " + (root2.next == null) + "\n");
        
        Node root3 = new Node(1);
        root3.left = new Node(2);
        root3.right = new Node(3);
        connect(root3);
        System.out.println("Test 3 - tree=[1,2,3]");
        System.out.println("Output: root.left.next.val = " + root3.left.next.val);
        System.out.println("Expected: 3");
        System.out.println("Pass: " + (root3.left.next.val == 3) + "\n");
    }
}
