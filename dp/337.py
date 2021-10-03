"""
Traverse tree in DFS way while tracking the sum. 
Apply DP while calculating the sum, which at any node is the maximum of:

its own value + it's grandchildren's level summation of max values
summation of it's children's max values
Using these, bubble up to get the answer.
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:

        def recur(root):
            if not root:
                return 0, 0
            l, prev_l = recur(root.left)
            r, prev_r = recur(root.right)

            # if rob parent, cannot rob children
            plan1 = root.val + prev_l + prev_r
            # if don't rob parent, we can either rob or
            # don't rob the children, whichever way is
            # more profitable
            # it present node and grandchildren are considered
            plan2 = l + r
            return max(plan1, plan2), plan2


class Solution2:
    def rob(self, root: Optional[TreeNode]) -> int:

        def dfs(node=root):
            if not node:
                return (0, 0)
            L, R = dfs(node.left), dfs(node.right)
            return (node.val+L[1]+R[1], max(L)+max(R))

        return max(dfs())
