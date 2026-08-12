class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
                continue;
            }
            if (nums[left] > nums[right]) {
                right = mid;
                left++;
                continue;
            }
            return nums[left];
        }
        return nums[left];
    }
}
