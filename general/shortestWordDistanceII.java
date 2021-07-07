import java.util.HashMap;
import java.util.ArrayList;

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
    private HashMap<String, ArrayList<Integer>> m = new HashMap<String, ArrayList<Integer>>();

    public void WordDistance(ArrayList<String> words) {
        for (int i = 0; i < words.size(); i++) {
            // push_back in c++
            String currentKey = words.get(i);
            if (m.get(currentKey) == null) {
                m.put(currentKey, new ArrayList<Integer>());
            }
            m.get(currentKey).add(i);

        }
    }

    int shortest(String word1, String word2) {
        int p1 = 0;
        int p2 = 0;
        int res = Integer.MAX_VALUE;
        while (p1 < m.get(word1).size() && p2 < m.get(word2).size()) {
            res = Math.min(res, Math.abs(m.get(word1).get(p1) - m.get(word2).get(p2)));

            if (m.get(word1).get(p1) < m.get(word2).get(p2)) {
                ++p1;
            } else {
                ++p2;
            }
        }
        return res;

    }
}
