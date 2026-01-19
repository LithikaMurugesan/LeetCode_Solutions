class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;


        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] =
                        mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int size = 1; i + size <= m && j + size <= n; size++) {

                    int sum =
                            prefix[i + size][j + size]
                            - prefix[i][j + size]
                            - prefix[i + size][j]
                            + prefix[i][j];

                    if (sum <= threshold) {
                        max = Math.max(max, size);
                    } else {
                        break; 
                    }
                }
            }
        }

        return max;
    }
}
