// Given an array of integers nums sorted in ascending order,
// find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        int lo = 0, hi = nums.length - 1;

        if (nums.length == 0)
            return res;
        // lo is the start index of target
        // hi is the end index of target
        while (nums[lo] < nums[hi]) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {// target is in the left half
                hi = mid - 1;
            } else if (nums[mid] < target) {// target is in the right half
                lo = mid + 1;
            } else {// find target, then need to find the start and end point
                if (nums[lo] == nums[mid]) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        // check whether find the target number
        if (nums[lo] == nums[hi] && nums[lo] == target) {
            res[0] = lo;
            res[1] = hi;
        }

        return res;
    }
}
