"""
Understand that the question only cares about the highest possibility that the code can get the secret word 
i.e. within 10 attempts, find the quickest way to get the secret word.

Therefore, we need to minimise the use of API master.guess() 
and once we have to call it, we need to narrow down the candidates.

We have x = master.guess(word)
if x == 6, we find the secret word, the algorithm ends
if x != 6, it means the secret word has exactly x matches with the word

Because the secret word has exactly x matches with the word, 
we can just search in the candidates, 
and only keep the ones that have exact x matches with the word. 
With that, we can narrow the candidates after we call master.guess(), 
and guarantee that the secret is in the remaining candidates.

Time: O(n) where n = len(wordlist) because the for loop runs 10 or fewer times O(10) and in each iteration, we traverse the wordlist: O(n) -> O(10*n) remove constant = O(n)
Space: O(n) because we run the check 10 times, each time we create a new list of candidates with at most n length -> O(10*n) remove constant = O(n)
"""
from random import randrange


class Solution:
    def findSecretWord(self, wordlist, master: 'Master') -> None:
        for _ in range(10):
            random_idx = randrange(len(wordlist))
            guess_word = wordlist[random_idx]
            matches = master.guess(guess_word)
            candidates = []
            for word in wordlist:
                if matches == self._get_matches_between(guess_word, word):
                    candidates.append(word)
            wordlist = candidates

    def _get_matches_between(self, word1, word2):
        matches = 0
        for i in range(len(word1)):
            if word1[i] == word2[i]:
                matches += 1
        return matches
