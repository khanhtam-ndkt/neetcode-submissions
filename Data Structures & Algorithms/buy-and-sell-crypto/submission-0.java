class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int minidx = 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[minidx]) {
                minidx = i;
            }
            if (prices[i] > prices[minidx]) {
                res = Math.max(res, prices[i] - prices[minidx]);
            }
        }
        return res;
    }
}
