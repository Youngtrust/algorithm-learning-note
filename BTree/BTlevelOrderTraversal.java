/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, 0);
        return result;
    }
    
    void dfs(List<List<Integer>> result, TreeNode root, int currLevel) {
        if (root == null) {
            return;
        }
        if (currLevel == result.size()) {
            result.add(new ArrayList<>());
        }
        
        result.get(currLevel).add(root.val);
        dfs(result, root.left, currLevel+1);
        dfs(result, root.right, currLevel+1);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //O(n)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size(); // queue is dynmiac
            for(int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                level.add(head.val);
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}