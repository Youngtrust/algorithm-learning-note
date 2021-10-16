/**
 * @param {number[]} nums
 * @return {number}
 */

// Intuition
// If we can do 0 move, return max(A) - min(A)
// If we can do 1 move, return min(the second max(A) - min(A), the max(A) - second min(A))
// and so on.

// Explanation

// kill 3 biggest elements
// kill 2 biggest elements + 1 smallest elements
// kill 1 biggest elements + 2 smallest elements
// kill 3 smallest elements

var minDifference = function (nums) {
  const len = nums.length;
  // let res = Number.MAX_VALUE
  nums.sort((a, b) => a - b);
  if (len < 5) return 0;

  return Math.min(
    nums[len - 1] - nums[3], // 3 elements removed from start 0 from end
    nums[len - 4] - nums[0], // 3 elements removed from end 0 from start
    nums[len - 2] - nums[2], // 2 elements removed from start 1 from end
    nums[len - 3] - nums[1] // 2 elements removed from end 1 from start
  );

  // return min(nums[-1] - nums[3], nums[-2] - nums[2], nums[-3] - nums[1], nums[-4] - nums[0])
};
