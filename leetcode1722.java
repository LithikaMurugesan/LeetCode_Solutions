class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            groups.computeIfAbsent(parent, x -> new ArrayList<>()).add(i);
        }

        int hammingDistance = 0;

        for (List<Integer> group : groups.values()) {
            Map<Integer, Integer> countMap = new HashMap<>();

            for (int idx : group) {
                countMap.put(source[idx], countMap.getOrDefault(source[idx], 0) + 1);
            }

            for (int idx : group) {
                if (countMap.getOrDefault(target[idx], 0) > 0) {
                    countMap.put(target[idx], countMap.get(target[idx]) - 1);
                } else {
                    hammingDistance++;
                }
            }
        }

        return hammingDistance;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pa] = pb;
    }
}
