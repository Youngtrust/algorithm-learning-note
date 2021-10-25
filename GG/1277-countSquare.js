// Input: matrix =
// [
//   [0,1,1,1],
//   [1,1,1,1],
//   [0,1,1,1]
// ]
// Output: 15
// Explanation:
// There are 10 squares of side 1.
// There are 4 squares of side 2.
// There is  1 square of side 3.
// Total number of squares = 10 + 4 + 1 = 15.

/**
 * @param {number[][]} matrix
 * @return {number}
 */
let countSquares = (A, cnt = 0) => {
  let M = A.length,
    N = A[0].length;
  let dp = [...Array(M + 1)].map((row) => Array(N + 1).fill(0));
  for (let i = 1; i <= M; ++i)
    for (let j = 1; j <= N; ++j)
      if (A[i - 1][j - 1])
        cnt += dp[i][j] =
          1 + Math.min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
  return cnt;
};
