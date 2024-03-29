"""
https://leetcode.com/problems/longest-string-chain/


Initially, each word's longest chain is set to 1. 
Then, we loop the list of words to find out whether it has a predecessor in the list. 
If there is a predecessor, we know current word's longest chain could be predecessor's longest chain plus one.

There are two main points for this solution:

Sort the word list words by each length of the word.
As mentioned above, current word's longest chain is formed by predecessor's longest chain plus one. 
Therefore, we must calculate the predecessor's longest chain first, otherwise the answer would be incorrect.

Comparing the current word's chain with all its predecessor's longest chain plus one to find out the current word's longest chain.
This is because the current word's chain could possibly be formed in many different ways, 
so we need to compare them to find out the longest one.

 d[word] is the longest chain ending at word.
        We sort the words by length, iterate through them, and generate all predecessors by removing letters.
        If a predecessor p is in d, d[word] = max(1 + d[p], d[word])
        We can track the max value along the way as well.
        
        Analysis
        Time:
            - Building the DP dictionary: O(n * k) where k is the biggest word length in words. 
                For each word we do len(word) operations to calculate predecessors.
                Lookups and updates to the dict are O(1), so our total time is O(n * k).
        Space:
            - Building the DP dictionary: O(n), since we have 1 entry for each word. O(n) overall.

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].

"""


class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        d = dict()
        for word in words:
            d[word] = 1
        longest = 1
        for word in sorted(words, key=len):
            for i in range(len(word)):
                prev = word[:i] + word[i + 1:]
                if prev in d:
                    d[word] = max(d[word], d[prev] + 1)
            longest = max(longest, d[word])
        return longest
