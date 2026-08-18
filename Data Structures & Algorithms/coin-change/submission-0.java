class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i - c >= 0 && dp[i - c] != -1) {
                    min = Math.min(min, dp[i - c] + 1);
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min;
            }
        }
        return dp[dp.length - 1];
    }
}
/*
    12
    0   1   2   3   4   5   6   7   8   9   10  11  12
    0   1   2   3   4   
*/