class Solution {
    public int maxSubArray(int[] nums) {
        int add = nums[0];
        int total = nums[0];
        
        for(int i=1; i<nums.length; i++){
            add = Math.max(nums[i], nums[i] + add);
            total = Math.max(add, total);
        }
       
        return total;
    }
}