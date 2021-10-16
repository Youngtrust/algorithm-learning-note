/**
 * @param {string[]} words
 * @return {number}
 */
var longestStrChain = function (words) {
  const d = {};
  // O(NlogN)
  words.sort((a, b) => (a.length > b.length ? 1 : -1));
  console.log(words);
  // [ 'b', 'a', 'ba', 'bda', 'bca', 'bdca' ]

  // O(N)
  words.forEach((eachWord, index) => {
    d[eachWord] = 1;
    // O(L)
    for (let i = 0; i < eachWord.length; i++) {
      let prev = eachWord.slice(0, i) + eachWord.slice(i + 1);
      if (prev in d) {
        d[eachWord] = Math.max(d[eachWord], d[prev] + 1);
        // console.log(eachWord, d[eachWord], d[prev]+1, Math.max(d[eachWord], d[prev]+1))

        // ba 1 2 2
        // ba 2 2 2
        // bda 1 3 3
        // bca 1 3 3
        // bdca 1 4 4
        // bdca 4 4 4
      }
    }
  });
  console.log(d);
  //   { b: 1, a: 1, ba: 2, bda: 3, bca: 3, bdca: 4 }
  console.log(Object.values(d));
  // [ 1, 1, 2, 3, 3, 4 ]

  return Math.max(...Object.values(d));
};

// Time complexity: O(N*(logN+L ^2))
