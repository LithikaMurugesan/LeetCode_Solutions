class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;

        long[] free = new long[k + 1];
        long[] buy = new long[k + 1];
        long[] sell = new long[k + 1];
        for (int t = 0; t <= k; t++) {
            buy[t] = Long.MIN_VALUE / 2;
            sell[t] = Long.MIN_VALUE / 2;
        }
        for (int price : prices) {
            for (int t = k; t >= 1; t--) {
                free[t] = Math.max(
                        free[t],
                        Math.max(buy[t] + price, sell[t] - price)
                );

                buy[t] = Math.max(buy[t], free[t - 1] - price);
                sell[t] = Math.max(sell[t], free[t - 1] + price);
            }
        }

        return free[k];
    }
}
