/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var upsideDownBinaryTree = function (root) {
  if (!root || (!root.left && !root.right)) {
    return root;
  }

  //The original left child becomes the new root.
  var newRoot = upsideDownBinaryTree(root.left);

  //The original root becomes the new right child.
  root.left.left = root.right;
  root.left.right = root;
  //The original right child becomes the new left child.
  root.left = null;
  root.right = null;

  return newRoot;
};
