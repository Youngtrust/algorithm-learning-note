"""
Given an integer array of even length arr,
 return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] 
 for every 0 <= i < len(arr) / 2, or false otherwise.

Example 1:

Input: arr = [3,1,3,6]
Output: false

Example 2:

Input: arr = [2,1,2,6]
Output: false

Example 3:

Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
Example 4:

Input: arr = [1,2,4,16,8,4]
Output: false

Let's try to (virtually) "write" the final reordered array.

Let's check elements in order of absolute value. 
When we check an element x and it isn't used, 
it must pair with 2*x. We will attempt to write x, 2x - 

if we can't, then the answer is false. If we write everything, the answer is true.

To keep track of what we have not yet written, we will store it in a count


Time Complexity: O(NlogN), where N is the length of A.
Space Complexity: O(N)
"""


class Solution(object):
    def canReorderDoubled(self, A):
        count = collections.Counter(A)
        for x in sorted(A, key=abs):
            if count[x] == 0:
                continue
            if count[2*x] == 0:
                return False
            count[x] -= 1
            count[2*x] -= 1

        return True


# >>> from collections import Counter
# >>>
# >>> myList = [1,1,2,3,4,5,3,2,3,4,2,1,2,3]
# >>> print Counter(myList)
# Counter({2: 4, 3: 4, 1: 3, 4: 2, 5: 1})
# >>>
# >>> print Counter(myList).items()
# [(1, 3), (2, 4), (3, 4), (4, 2), (5, 1)]
# >>>
# >>> print Counter(myList).keys()
# [1, 2, 3, 4, 5]
# >>>
# >>> print Counter(myList).values()
# [3, 4, 4, 2, 1]
