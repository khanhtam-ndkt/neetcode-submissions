class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // System.out.println("Left: " + left + ", right: " + right);
            int mid = left + (right - left) / 2;
            // System.out.println("Mid: " + mid);
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


// 0 1 2 3 4 5 6
// 2 + (5 - 2) / 2 = 3