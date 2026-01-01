/**
 * TreeNode - Binary Tree Node Definition
 * 
 * This class represents a node in a binary tree.
 * It includes utility methods for creating and manipulating trees.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode() {}
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    /**
     * Create a binary tree from level-order array
     * null represents missing nodes
     */
    public static TreeNode createTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }
        
        TreeNode root = new TreeNode(values[0]);
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        int i = 1;
        
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();
            
            if (values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.add(node.left);
            }
            i++;
            
            if (i < values.length && values[i] != null) {
                node.right = new TreeNode(values[i]);
                queue.add(node.right);
            }
            i++;
        }
        
        return root;
    }
    
    /**
     * Convert tree to level-order array for easy comparison
     */
    public static Integer[] treeToArray(TreeNode root) {
        if (root == null) {
            return new Integer[0];
        }
        
        java.util.List<Integer> result = new java.util.ArrayList<>();
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        
        // Remove trailing nulls
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        
        return result.toArray(new Integer[0]);
    }
    
    /**
     * Check if two trees are equal
     */
    public static boolean isEqual(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isEqual(p.left, q.left) && isEqual(p.right, q.right);
    }
    
    /**
     * Get height of tree
     */
    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    
    /**
     * Count nodes in tree
     */
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
