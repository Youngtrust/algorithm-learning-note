public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int fbinarySearch(int[] nums, int target) {
        // write your code here
        if(nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if(nums[mid] == target){
                end = mid;
            }else if(nums[mid] < target){
                start = mid;
            }else if(nums[mid] > target){
                end = mid;
            }
        }

        if(nums[start] == target){
            return start;
        }if(nums[end] == target){
            return end;
        }
        return -1;
    }
}