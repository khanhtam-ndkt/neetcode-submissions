class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] rob = new int[nums.length];
        int[] skip = new int[nums.length];
        rob[0] = nums[0];
        skip[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            rob[i] = skip[i - 1] + nums[i];
            skip[i] = Math.max(rob[i - 1], skip[i - 1]);
        }
        return Math.max(rob[nums.length - 1], skip[nums.length - 1]);
    }
}
