class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int max = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        for (int[] row : matrix) {
            Arrays.sort(row);

            for (int j = 0; j < n; j++) {
                int height = row[n - 1 - j]; 
                int width = j + 1;
                max = Math.max(max, height * width);
            }
        }

        return max;
    }
}
