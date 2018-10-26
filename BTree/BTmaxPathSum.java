/*
given a binary tree, find the maximum path sum
the path may start and end at any node in the tree
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // O(n)
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
    private class ResultType{
        int singlePath;
        int maxPath;
        ResultType(int singlePath, int maxPath){
            this.singlePath = singlePath;//一个方向走， 可以没有点
            this.maxPath = maxPath; //final res， 至少一个点
        }
    }
    
    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0, Integer.MIN_VALUE);
        }
        //Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
            
        //Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);
            
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
            
        return new ResultType(singlePath, maxPath);
    }
    
    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
}