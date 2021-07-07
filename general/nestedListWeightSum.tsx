/**
 * Given a nested list of integers, return the sum of all integers in the list
 * weighted by their depth. Each element is either an integer, or a list --
 * whose elements may also be integers or other lists.
 *
 * Input: [[1,1],2,[1,1]] Output: 10 Explanation: Four 1's at depth 2, one 2 at
 * depth 1.
 *
 */
// const depthSum = (nestedList: Array<any>) => {
//   let res = 0;
//   nestedList.forEach((eachEle) => {
//     res += _getSum(eachEle, 1);
//   });
//   return res;
// };

// const _getSum = (nestedInteger: any, level: number) => {
//   let res = 0;

//   if (!isNaN(nestedInteger)) return level * parseInt(nestedInteger);

//   nestedInteger.forEach((eachEle) => {
//     res += _getSum(eachEle, level + 1);
//   });

//   return res;
// };

const depthSum = (nestedList: Array<any>) => {
  return _helper(nestedList, 1);
};

const _helper = (nestedInteger: any, depth: number) => {
  let res = 0;

  nestedInteger.forEach((eachEle) => {
    res += !isNaN(eachEle)
      ? parseInt(eachEle) * depth
      : _helper(eachEle, depth + 1);
  });
  return res;
};
