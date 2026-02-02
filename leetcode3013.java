class Container {

    private int k;
    private int st1Size;
    private int st2Size;
    private TreeMap<Integer, Integer> st1;
    private TreeMap<Integer, Integer> st2;
    private long sm;

    public Container(int k) {
        this.k = k;
        st1 = new TreeMap<>();
        st2 = new TreeMap<>();
    }

    private void addOne(TreeMap<Integer,Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    private void removeOne(TreeMap<Integer,Integer> map, int x) {
        int c = map.get(x);
        if (c == 1) map.remove(x);
        else map.put(x, c-1);
    }

    private void adjust() {
        while (st1Size < k && !st2.isEmpty()) {
            int x = st2.firstKey();
            addOne(st1, x);
            st1Size++;
            sm += x;
            removeOne(st2, x);
            st2Size--;
        }

        while (st1Size > k) {
            int x = st1.lastKey();
            addOne(st2, x);
            st2Size++;
            removeOne(st1, x);
            st1Size--;
            sm -= x;
        }
    }

    public void add(int x) {
        if (!st2.isEmpty() && x >= st2.firstKey()) {
            addOne(st2, x);
            st2Size++;
        } else {
            addOne(st1, x);
            st1Size++;
            sm += x;
        }
        adjust();
    }

    public void erase(int x) {
        if (st1.containsKey(x)) {
            removeOne(st1, x);
            st1Size--;
            sm -= x;
        } else if (st2.containsKey(x)) {
            removeOne(st2, x);
            st2Size--;
        }
        adjust();
    }

    public long sum() {
        return sm;
    }
}

class Solution {

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        Container cnt = new Container(k - 2);

        for (int i = 1; i < k - 1; i++) {
            cnt.add(nums[i]);
        }

        long ans = cnt.sum() + nums[k - 1];

        for (int i = k; i < n; i++) {
            int j = i - dist - 1;
            if (j > 0) cnt.erase(nums[j]);
            cnt.add(nums[i - 1]);
            ans = Math.min(ans, cnt.sum() + nums[i]);
        }

        return ans + nums[0];
    }
}
