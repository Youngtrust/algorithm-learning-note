// The idea is to scan each cell in the matrix
// to update the placeholder result variable with the number of squares
// that can be formed from the currently looking cell
// (when it is the bottom right corner cell of the any possible square).

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
