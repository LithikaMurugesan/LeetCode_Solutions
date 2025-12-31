class Solution {
    int rows, cols;
    int[][] grid;
    boolean[][] visited;

    public int latestDayToCross(int row, int col, int[][] cells) {
        rows = row;
        cols = col;

        int left = 0, right = cells.length - 1;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCross(mid, cells)) {
                ans = mid + 1;   
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    boolean canCross(int day, int[][] cells) {
        grid = new int[rows][cols];
        for (int i = 0; i <= day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }

        visited = new boolean[rows][cols];
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 0 && !visited[0][j]) {
                if (dfs(0, j)) return true;
            }
        }
        return false;
    }

    boolean dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= rows || c >= cols) return false;
        if (grid[r][c] == 1 || visited[r][c]) return false;

        if (r == rows - 1) return true;

        visited[r][c] = true;

        return dfs(r + 1, c) || dfs(r - 1, c) ||
               dfs(r, c + 1) || dfs(r, c - 1);
    }
}
