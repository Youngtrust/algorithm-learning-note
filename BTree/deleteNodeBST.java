/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                int min = findMin(root.right);
                
                root.val = min;
                root.right = deleteNode(root.right, min);
            }
        }
        
        return root;
    }
    
    private int findMin(TreeNode root) {
        if (root == null) return -9999999;
        
        if (root.left != null) return findMin(root.left);
        else return root.val;
    }
}