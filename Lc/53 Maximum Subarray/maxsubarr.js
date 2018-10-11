/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    if (nums.length === 0) {
        return 0;    
    }
    
    let max = nums[0];
    let localMax = nums[0];
    for (let i = 1; i < nums.length; i++) {
        localMax = Math.max(localMax + nums[i], nums[i]);
        max = Math.max(max, localMax);
    }
    
    return max;
};