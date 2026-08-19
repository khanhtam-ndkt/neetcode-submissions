class Solution {
    public int maxProfit(int[] prices) {
        int[] hold = new int[prices.length]; // have neetcoin 
        int[] sell = new int[prices.length]; // sell neetcoin
        int[] rest = new int[prices.length]; // not have neetcoin

        hold[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            // in hold state: already bought a stock or just finished resting
            hold[i] = Math.max(rest[i - 1] - prices[i], hold[i - 1]);
            // in sell state: already holding stock
            sell[i] = hold[i - 1] + prices[i];
            // in rest state: after selling or continue resting
            rest[i] = Math.max(rest[i - 1], sell[i - 1]);
        }

        return Math.max(sell[prices.length - 1], rest[prices.length - 1]);
    }
}
