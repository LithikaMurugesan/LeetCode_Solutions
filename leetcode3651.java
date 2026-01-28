class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int INF = Integer.MAX_VALUE;

        int[][][] dist = new int[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dist[i][j], INF);

        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{grid[i][j], i, j});
        cells.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        pq.offer(new int[]{0, 0, 0, 0});
        dist[0][0][0] = 0;

        int[] dr = {0, 1};
        int[] dc = {1, 0};
        int[] ptr = new int[k + 1];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], r = cur[1], c = cur[2], t = cur[3];

            if (cost > dist[r][c][t]) continue;
            if (r == m - 1 && c == n - 1) return cost;

            for (int d = 0; d < 2; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < m && nc < n) {
                    int newCost = cost + grid[nr][nc];
                    if (newCost < dist[nr][nc][t]) {
                        dist[nr][nc][t] = newCost;
                        pq.offer(new int[]{newCost, nr, nc, t});
                    }
                }
            }

            if (t < k) {
                while (ptr[t] < cells.size() &&
                       cells.get(ptr[t])[0] <= grid[r][c]) {

                    int[] cell = cells.get(ptr[t]++);
                    int nr = cell[1], nc = cell[2];

                    if (cost < dist[nr][nc][t + 1]) {
                        dist[nr][nc][t + 1] = cost;
                        pq.offer(new int[]{cost, nr, nc, t + 1});
                    }
                }
            }
        }

        return -1;
    }
}
