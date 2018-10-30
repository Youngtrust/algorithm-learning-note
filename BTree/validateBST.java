/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * inorder traversal is 升序
 */
class Solution {
    private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(!firstNode && lastVal >= root.val){
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if(!isValidBST(root.right)){
            return false;
        }
        return true;    
    }
}

/*
class Solution {
    public boolean isValidBST(TreeNode root) {
        long maxValue = Long.MAX_VALUE;
        long minValue = Long.MIN_VALUE;
        return isValidBST(root, maxValue, minValue);
    }
    
    private boolean isValidBST(TreeNode root, long maxValue, long minValue){
        if(root == null){
            return true;
        }
        
        if(root.val >= maxValue || root.val <= minValue){
            return false;
        }
        
        return isValidBST(root.left, root.val, minValue) && isValidBST(root.right, maxValue, root.val);
    }
}
*/

