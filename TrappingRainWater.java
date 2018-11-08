/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


*/
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length -  1;
        int ans = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                int h = height[l++];
                while (l < r && height[l] <= h) {
                    ans += h - height[l++];
                }
            } else {
                int h = height[r--];
                while (l < r && height[r] <= h) {
                    ans += h - height[r--];
                }
            }
        }
        return ans;
    }
}