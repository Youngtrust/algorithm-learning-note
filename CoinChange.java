/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*/

/*
F(S)=F(S−C)+1

*/

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        final int INF = 0x7fffffff;
        for (int i = 1; i <= amount; i++) dp[i] = INF;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] != INF && i + coins[j] <= amount && dp[i]!= INF)
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }
}