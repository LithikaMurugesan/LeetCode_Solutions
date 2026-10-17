class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 0; i < n; i++) {
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
