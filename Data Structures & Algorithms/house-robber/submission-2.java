class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i < 3) {
                dp[i] = dp[i - 2] + nums[i];
            }
            else {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            }
        }
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
}

/*

    1   9   7   1   6
            10      

*/