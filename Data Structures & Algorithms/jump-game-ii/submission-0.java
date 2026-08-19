class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 || dp[i] == -1) continue;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j > nums.length - 1) break;
                dp[i + j] = dp[i + j] == -1 ? dp[i] + 1 :
                    Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}

/*

        2   4   1   1   1   1
i=0     0   1   1   0   0   0
i=1     0   1  [1]  2   2   2

        2   1   2   1   0
        0   1   1   -1  -1
            1  [1]  -1  -1



*/