class Solution {
    public long minimumCost(
        String source,
        String target,
        String[] original,
        String[] changed,
        int[] cost
    ) {
        int n = source.length();
        long INF = (long) 1e18;


        Set<String> set = new HashSet<>();
        for (String s : original) set.add(s);
        for (String s : changed) set.add(s);

        Map<String, Integer> id = new HashMap<>();
        int idx = 0;
        for (String s : set) id.put(s, idx++);

        int m = id.size();

        long[][] dist = new long[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }


        for (int k = 0; k < m; k++)
            for (int i = 0; i < m; i++)
                for (int j = 0; j < m; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

    
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            for (String from : set) {
                int len = from.length();
                if (i + len > n) continue;

                String to = target.substring(i, i + len);

                if (source.substring(i, i + len).equals(from)
                        && id.containsKey(to)) {

                    long c = dist[id.get(from)][id.get(to)];
                    if (c < INF) {
                        dp[i + len] = Math.min(dp[i + len], dp[i] + c);
                    }
                }
            }
        }

        return dp[n] == INF ? -1 : dp[n];
    }
}
