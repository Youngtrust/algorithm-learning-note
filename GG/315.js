/**
 * @param {number[]} nums
 * @return {number[]}
 */

//  算法题
//      给一个数组, 如 [2, 1, 3]，找出每个数字在该数字之后比它大的数的个数，比如：
//      比 2 大的有 3，所以结果是 1，
//      比 1 大的有 3，结果也是 1，

//  比 3 大的没有，结果是 0，
//      所以返回 [1, 1, 0];

var countSmaller = function (nums) {
  if (nums.length === 0) return [];

  let counts = [0];
  let orderedNums = [nums[nums.length - 1]];

  const bs = (target) => {
    let start = 0;
    let end = orderedNums.length;
    while (start < end) {
      let mid = Math.floor((start + end) / 2);
      if (target > orderedNums[mid]) start = mid + 1;
      else end = mid;
    }
    orderedNums.splice(start, 0, target);
    return start;
  };

  for (let i = nums.length - 2; i >= 0; i--) {
    let count = bs(nums[i]);
    counts.unshift(count);
  }
  return counts;
};
