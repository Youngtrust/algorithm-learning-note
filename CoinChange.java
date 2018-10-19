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
class Solution {
    public int coinChange(int[] coins, int amount) {
        return first(coins, amount);
    }

    private int ans;
    public int first(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return amount == 0 ? 1 : -1;
        }
        ans = amount + 1;
        Arrays.sort(coins);
        helper(coins, amount, 0, coins.length-1);
        return ans == amount + 1 ? -1 : ans;
    }


    public void helper(int[] coins, int remain, int numCoins, int idx) {
        int coin = coins[idx];
        if (idx == 0) {
            if (remain % coin == 0) {
                this.ans = Math.min(this.ans, numCoins + remain / coin);
            }
        } else {
            int k = remain / coin;
            while (k >= 0 && numCoins + k < this.ans) {
                /** remain will never be negative */
                helper(coins, remain - k * coin, numCoins+k, idx-1);
                k--;
            }
        }
    }
}