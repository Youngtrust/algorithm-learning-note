public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */

    //start + 1 < end;
    //start + (end - start)/2;
    // nums[mid]  == < >
    //nums[start], nums[end] ? target
    
    public int fbinarySearch(int[] nums, int target) {
        // write your code here
        if(nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;

        //start + 1 < end
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

        // asked to find 1st position; if start first
        if(nums[start] == target){
            return start;
        }if(nums[end] == target){
            return end;
        }
        return -1;
    }
}