class Solution {
    public int maxArea(int[] heights) {
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int water = (right - left) * Math.min(heights[left], heights[right]);
            res = Math.max(res, water);
            if (heights[left] > heights[right]) {
                right--;
            }
            else left++;
        }
        return res;
    }
}
