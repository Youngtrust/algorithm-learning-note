/*
Given an integer array of size n, find all elements that appear more than ⌊ 1/k ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,1,2,3,233,4,4,4] and k = 3
Output: 3

*/
class Solution:

    def majorityNumber(self, nums, k):
        key:candidate
        value: co
        unt

        for num in nums:
            hash[num] = hash.get(num, 0)+1
            if hash.size() == k:
                for key in hash:
                    hash[key] --;
                    if hash[key] == 0:
                        delete key
        for num in nums: