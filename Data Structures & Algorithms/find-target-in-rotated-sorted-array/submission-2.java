class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int minidx = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else if (nums[mid] < nums[left]) {
                if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                    minidx = mid;
                    break;
                }
                right = mid - 1;
            }
            else {
                minidx = left;
                break;
            }
        }
        System.out.println(minidx);
        if (minidx != 0 && target >= nums[0]) {
            left = 0;
            right = minidx - 1;
        }
        else {
            left = minidx;
            right = nums.length - 1;
        }
        System.out.println("Left: " + left + ", right: " + right);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}