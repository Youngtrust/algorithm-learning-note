"""
Input: nestedList = [[1,1],2,[1,1]]
Output: 10
Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.

"""


class Solution(object):
    def depthSum(self, nestedList):
        """
        :type nestedList: List[NestedInteger]
        :rtype: int
        """
        def DFS(nestedList, depth):
            temp_sum = 0
            for member in nestedList:
                if member.isInteger():
                    temp_sum += member.getInteger() * depth
                else:
                    temp_sum += DFS(member.getList(), depth+1)
            return temp_sum
        return DFS(nestedList, 1)
