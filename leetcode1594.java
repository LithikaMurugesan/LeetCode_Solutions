class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long MOD = 1_000_000_007;

        long[][] dpMin = new long[m][n];
        long[][] dpMax = new long[m][n];
        dpMin[0][0] = grid[0][0];
        dpMax[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
            
                if (i == 0 && j == 0) continue;

                long val = grid[i][j];
                long minVal = Long.MAX_VALUE;
                long maxVal = Long.MIN_VALUE;
                if (i > 0) {
                    long topMin = dpMin[i - 1][j] * val;
                    long topMax = dpMax[i - 1][j] * val;
                    minVal = Math.min(minVal, Math.min(topMin, topMax));
                    maxVal = Math.max(maxVal, Math.max(topMin, topMax));
                }

                if (j > 0) {
                    long leftMin = dpMin[i][j - 1] * val;
                    long leftMax = dpMax[i][j - 1] * val;
                    minVal = Math.min(minVal, Math.min(leftMin, leftMax));
                    maxVal = Math.max(maxVal, Math.max(leftMin, leftMax));
                }

                dpMin[i][j] = minVal;
                dpMax[i][j] = maxVal;
            }
        }
        long result = dpMax[m - 1][n - 1];

        if (result < 0) {
            return -1;
        } else {
            return (int) (result % MOD);
        }
    }
}
