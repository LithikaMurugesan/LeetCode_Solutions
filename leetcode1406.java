public class Solution {
    public static String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 3];
        for (int i = n - 1; i >= 0; --i) {
            int takeSum = 0;
            int best = Integer.MIN_VALUE;
            for (int k = 1; k <= 3; ++k) {
                if (i + k - 1 < n) {
                    takeSum += stoneValue[i + k - 1];
                    int candidate = takeSum - dp[i + k];
                    if (candidate > best) best = candidate;
                }
            }
            dp[i] = best;
        }
        if (dp[0] > 0) return "Alice";
        else if (dp[0] < 0) return "Bob";
        else return "Tie";
    }

    public static void main(String[] args) {
        int[] stones = {1, 2, 3, 7};
        System.out.println(stoneGameIII(stones)); 
    }
}
