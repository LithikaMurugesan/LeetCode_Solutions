class Solution {

    int[] parent;
    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py)
            parent[py] = px;a
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        boolean[] knows = new boolean[n];
        knows[0] = true;
        knows[firstPerson] = true;

        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int i = 0;
        while (i < meetings.length) {

            int time = meetings[i][2];
            List<Integer> people = new ArrayList<>();
            while (i < meetings.length && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];
                union(x, y);
                people.add(x);
                people.add(y);
                i++;
            }
            Set<Integer> groupsWithSecret = new HashSet<>();
            for (int p : people) {
                if (knows[p]) {
                    groupsWithSecret.add(find(p));
                }
            }

            for (int p : people) {
                if (groupsWithSecret.contains(find(p))) {
                    knows[p] = true;
                }
            }
            for (int p : people) {
                parent[p] = p;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (knows[j])
                result.add(j);
        }

        return result;
    }
}
