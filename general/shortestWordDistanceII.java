import java.util.HashMap;

/* Design a class which receives a list of words in the constructor, 
and implements a method that takes two words word1 and word2 
and return the shortest distance between these two words in the list. 

Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1

You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

 O(M+N) M & N are length for word1 & word2
*/
public class shortestWordDistanceII {
    private unordered_map<String, Array<Integer>> m = new HashMap<String, Array<Integer>>();

    public WordDistance(Array<String> words){
        for(int i : words.length){
            // push_back in c++ 
            string currentKey = words[i];
            if(m.get(currentKey) == null){
                m.put(currentKey, new Array<Integer>());
            }
            m.get(currentKey).add(i);

        }
    }

    int shortest(String word1, String word2) {
        int p1 = 0;
        int p2 = 0;
        int res = Integer.MAX_VALUE;
        while (p1 < m[word1].length && p2 < m[word2].length) {
            res = Math.min(res, Math.abs(m[word1][p1] - m[word2][p2]));

            if (m[word1][p1] < m[word2][p2]) {
                ++p1;
            } else {
                ++p2;
            }
        }
        return res;

    }
}
