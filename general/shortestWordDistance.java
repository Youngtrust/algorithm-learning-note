/* Given a list of words and two words word1 and word2, 
return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1

*/
public class shortestWordDistance {
    public int shortestDistance(Array<String> words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int res = Integer.MAX_VALUE;

        for (int i : words.length) {
            if (words[i] == word1)
                p1 = i;
            else if (words[i] == word2)
                p2 = i;
            if (p1 != -1 && p2 != -1)
                res = Math.min(res, Math.abs(p1 - p2));
        }
        return res;

    }
}
