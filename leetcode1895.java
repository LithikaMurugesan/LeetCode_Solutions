class Solution {

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxSize = Math.min(m, n);
        for (int k = maxSize; k >= 1; k--) {
            for (int r = 0; r + k <= m; r++) {
                for (int c = 0; c + k <= n; c++) {
                    if (isMagic(grid, r, c, k)) {
                        return k;
                    }
                }
            }
        }
        return 1;
    }

    private boolean isMagic(int[][] grid, int r, int c, int k) {
        int targetSum = 0;
        for (int j = 0; j < k; j++) {
            targetSum += grid[r][c + j];
        }
        for (int i = 0; i < k; i++) {
            int rowSum = 0;
            for (int j = 0; j < k; j++) {
                rowSum += grid[r + i][c + j];
            }
            if (rowSum != targetSum) return false;
        }

        for (int j = 0; j < k; j++) {
            int colSum = 0;
            for (int i = 0; i < k; i++) {
                colSum += grid[r + i][c + j];
            }
            if (colSum != targetSum) return false;
        }

        int diag1 = 0;
        for (int i = 0; i < k; i++) {
            diag1 += grid[r + i][c + i];
        }
        if (diag1 != targetSum) return false;
        int diag2 = 0;
        for (int i = 0; i < k; i++) {
            diag2 += grid[r + i][c + k - 1 - i];
        }
        if (diag2 != targetSum) return false;

        return true;
    }
}
