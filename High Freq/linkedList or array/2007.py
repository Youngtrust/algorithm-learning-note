"""
Input: changed = [1,3,4,2,6,8]
Output: [1,3,4]
Explanation: One possible original array could be [1,3,4]:
- Twice the value of 1 is 1 * 2 = 2.
- Twice the value of 3 is 3 * 2 = 6.
- Twice the value of 4 is 4 * 2 = 8.
Other original arrays could be [4,3,1] or [3,1,4].

Input: changed = [6,3,0,1]
Output: []
Explanation: changed is not a doubled array.

"""


class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        if len(changed) % 2 == 1:
            return []

        original = []
        numbers = collections.Counter(changed)

        for n in sorted(changed):
            v = n*2
            if numbers.get(n, 0) > 0 and numbers.get(v, 0) > 0:
                original.append(n)
                numbers[n] -= 1
                numbers[v] -= 1
            elif n // 2 not in numbers or n % 2 == 1:
                # In Python 3.x, 5 / 2 will return 2.5 and 5 // 2 will return 2. The former is floating point
                return []

        return original
