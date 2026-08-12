class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else if (nums[mid] < nums[left]) {
                if (mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                    return nums[mid];
                right = mid - 1;
            }
            else {
                return nums[left];
            }
        }
        return nums[left];
    }
}