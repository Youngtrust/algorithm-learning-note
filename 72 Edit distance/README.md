Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
<br/>
You have the following 3 operations permitted on a word:
<br/>
Insert a character<br/>
Delete a character<br/>
Replace a character<br/>
<hr/>
Example 1:<br/>
<br/>
Input: word1 = "horse", word2 = "ros"<br/>
Output: 3<br/>
Explanation: <br/>
horse -> rorse (replace 'h' with 'r')<br/>
rorse -> rose (remove 'r')<br/>
rose -> ros (remove 'e')<br/>
<hr/>
Example 2:<br/>
<br/>
Input: word1 = "intention", word2 = "execution"<br/>
Output: 5<br/>
Explanation: <br/>
intention -> inention (remove 't')<br/>
inention -> enention (replace 'i' with 'e')<br/>
enention -> exention (replace 'n' with 'x')<br/>
exention -> exection (replace 'n' with 'c')<br/>
exection -> execution (insert 'u')<br/>
