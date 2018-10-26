class Solution {
    public int maxdepthBT(TreeNode root) {
        return maxDepth(root);
    }
    
    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) +1;
    }
}