"""
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

"""


# class Solution: -> one line but not what interviewer want
#     def reverseString(self, s):
#         s.reverse()


class Solution:
    def reverseString(self, s: List[str]) -> None:

        def helper(left: int, right: int, string: List[str]):

            if left >= right:
                # base case
                return

            # general case
            s[left], s[right] = s[right], s[left]

            helper(left+1, right-1, s)
        # ------------------------------------------------

        helper(left=0, right=len(s)-1, string=s)
