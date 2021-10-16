"""

wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
Output: 3

wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1

"""


class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1 = p2 = -1
        min_d = len(wordsDict)

        for i, w in enumerate(wordsDict):
            if w == word1:
                p1 = i
            if w == word2:
                p2 = i

            # if p1!=-1 and p2!=-1:
            if -1 not in (p1, p2):
                min_d = min(min_d, abs(p1-p2))
        return min_d
