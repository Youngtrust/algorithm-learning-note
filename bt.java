//Binary Tree Traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Traverse
class Solution {
    public List<Integer> traversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    public void helper(TreeNode root, ArrayList<Integer> res){
        if(root == null){
            return;
        }
        result.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
//Divide & Conquer
class Solution {
    public List<Integer> traversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return result;
        }

        //divide
        ArrayList<Integer> left = traversal(root.left);
        ArrayList<Integer> right = traversal(root.right);

        //conquer
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return result;
    }
}