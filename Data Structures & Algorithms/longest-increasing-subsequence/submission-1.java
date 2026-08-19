class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[][] dp = new int[nums.length][2];
        // num of smaller numbers & idx of prev smaller number
        for (int i = 0; i < dp.length; i++) {
            dp[i][1] = -1;
        }
        for (int i = 1; i < nums.length; i++) {
            int count = 0;
            int idx = -1;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) continue;
                if (dp[j][0] + 1 > count) {
                    count = dp[j][0] + 1;
                    idx = j;
                }
            }
            dp[i][0] = count;
            dp[i][1] = idx;
        }
        int res = 0;
        for (int i[] : dp) {
            res = Math.max(res, i[0] + 1);
        }
        return res;
    }
}

/*

    10  22  9   33  21  50  41  60  80
    0   1   2   3   4   5   6   7   8

    0   1   0   2   
    -1  0   -1  1   

    
*/