class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }
        }
        return dp[dp.length - 1];
    }
}

/*
    1   2   3

        0   1   2   3   4
i=0     1   1   1   1   0
i=1     1   1   2   2   1
i=2     1   1   2           
        
    
                

*/