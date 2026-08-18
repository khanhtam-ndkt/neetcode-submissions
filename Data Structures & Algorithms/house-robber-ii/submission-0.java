class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob2d(nums, 0, nums.length - 2),
            rob2d(nums, 1, nums.length - 1));
    }

    public int rob2d(int[] nums, int start, int end) {
        int[] rob = new int[end - start + 1];
        int[] skip = new int[end - start + 1];
        rob[0] = nums[start];
        skip[0] = 0;
        for (int i = 1; i < rob.length; i++) {
            rob[i] = skip[i - 1] + nums[start + i];
            skip[i] = Math.max(rob[i - 1], skip[i - 1]);
        }
        return Math.max(rob[rob.length - 1], skip[skip.length - 1]);
    }
}
