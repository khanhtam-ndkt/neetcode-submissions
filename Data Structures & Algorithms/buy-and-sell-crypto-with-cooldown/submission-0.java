class Solution {
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] skip = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        skip[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], skip[i - 1] - prices[i]);
            sell[i] = buy[i - 1] + prices[i];
            skip[i] = Math.max(skip[i - 1], sell[i - 1]);
        }
        return Math.max(sell[prices.length - 1], skip[prices.length - 1]);
    }
}


/*

            1       3       4       0       4
buy         -1      -3      -4      0
sell        0       2       3       -1
skip        0       -1      -3



*/