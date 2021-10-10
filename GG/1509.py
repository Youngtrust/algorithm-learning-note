"""
Input: nums = [5,3,2,4]
Output: 0
Explanation: Change the array [5,3,2,4] to [2,2,2,2].
The difference between the maximum and minimum is 2-2 = 0.

All three biggest elements can be replaced with 14
[1,5,6,13,14,15,16,17] -> [1,5,6,13,14,14,14,14] == can be written as A[n-4] - A[0] == (14-1 = 13)

Case 2: kill 2 biggest elements + 1 smallest elements

[1,5,6,13,14,15,16,17] -> [5,5,6,13,14,15,15,15] == can be written as A[n-3] - A[1] == (15-5 = 10)

Case 3: kill 1 biggest elements + 2 smallest elements

[1,5,6,13,14,15,16,17] -> [6,6,6,13,14,15,16,16] == can be written as A[n-2] - A[2] == (16-6 = 10)

Case 4: kill 3 smallest elements

[1,5,6,13,14,15,16,17] -> [13,13,13,13,14,15,16,17] == can be written as A[n-1] - A[3] == (17-13 = 4)
"""


class Solution:
    # def minDifference(self, nums: List[int]) -> int:
    #     if len(nums) <= 4:
    #         return 0
    #     return min(nums[-1] - nums[3], nums[-2] - nums[2], nums[-3] - nums[1], nums[-4] - nums[0])
    def minDifference(self, A):
        A.sort()
        return min(b - a for a, b in zip(A[:4], A[-4:]))

# thislist = [1, 2, 3,4,5,6,7,8,9,0]
# print(thislist[:-2])
# print(thislist[-2:])
# [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
# [1, 2, 3, 4, 5, 6, 7, 8]
# [9, 0]
