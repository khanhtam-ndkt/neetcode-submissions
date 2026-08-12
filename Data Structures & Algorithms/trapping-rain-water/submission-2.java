class Solution {
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftW = 0;
        int rightW = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftW) {
                    leftW = height[left];
                }
                else {
                    res += leftW - height[left];
                }
                left++;
            }
            else {
                if (height[right] > rightW) {
                    rightW = height[right];
                }
                else {
                    res += rightW - height[right];
                }
                right--;
            }            
        }
        return res;
    }
}
