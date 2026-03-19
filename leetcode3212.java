class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] xPrefix = new int[m + 1][n + 1];
        int[][] yPrefix = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                xPrefix[i + 1][j + 1] = xPrefix[i][j + 1] + xPrefix[i + 1][j] - xPrefix[i][j];
                yPrefix[i + 1][j + 1] = yPrefix[i][j + 1] + yPrefix[i + 1][j] - yPrefix[i][j];

                if (grid[i][j] == 'X') {
                    xPrefix[i + 1][j + 1]++;
                } else if (grid[i][j] == 'Y') {
                    yPrefix[i + 1][j + 1]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int xCount = xPrefix[i + 1][j + 1];
                int yCount = yPrefix[i + 1][j + 1];

                if (xCount == yCount && xCount > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
