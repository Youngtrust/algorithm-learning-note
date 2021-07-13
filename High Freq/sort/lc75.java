// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;

        while (i <= end) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[start] = 0;
                start++;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                i++;
            }
        }

    }
}