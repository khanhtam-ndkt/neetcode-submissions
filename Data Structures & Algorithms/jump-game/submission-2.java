class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 || dp[i] == false) continue;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length - 1) return true;
                dp[i + j] = true;
            }
        }
        return dp[nums.length - 1];
    }
}
