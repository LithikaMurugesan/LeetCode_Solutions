class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
       for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                } 
            }
        }
        return count;
    }
    static boolean isMagic(int[][] grid, int r, int c){
      if (grid[r+1][c+1] != 5) return false;
        
     boolean[] seen = new boolean[10];
         for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || seen[num]) return false;
                seen[num] = true;
            }
        }
        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
          for (int i = 0; i < 3; i++) {
            int rowSum = grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2];
            if (rowSum != sum) return false;
        }
          for (int j = 0; j < 3; j++) {
            int colSum = grid[r][c+j] + grid[r+1][c+j] + grid[r+2][c+j];
            if (colSum != sum) return false;
        }
        int d1 = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
        int d2 = grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];

        return d1 == sum && d2 == sum;
    }
}