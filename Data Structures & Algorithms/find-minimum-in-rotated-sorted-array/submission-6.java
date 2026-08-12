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
                right--;
            }
        }
        return nums[left];
    }
}

// 5 6 0 1 2 3 4
// mid: 1
// mid 1 < 5 -> l = 5, r = 0
// 5 6 0
// mid 6 > right -> l = 0,