/*
Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.
Example
Given [1, 1, 1, 1, 2, 2, 2], return 1
Challenge
O(n) time and O(1) extra space
*/
class Solution {
    public int majorityElement(int[] num) {
        
        int major=num[0], count = 1;
        
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
}