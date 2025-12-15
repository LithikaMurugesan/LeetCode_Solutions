class Solution {
    public long getDescentPeriods(int[] prices) {
        long result = 0;
        long count = 1;

        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] == prices[i - 1] - 1) {
                count++;
            } else {
                count = 1;
            }
            result += count;
        }

        return result;
    }
}
