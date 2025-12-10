class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int k_left, int sum_left,
                           List<Integer> path, List<List<Integer>> res) {
        if (k_left == 0 && sum_left == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (k_left == 0 || sum_left < 0) return;

        for (int num = start; num <= 9; num++) {
            path.add(num);
            backtrack(num + 1, k_left - 1, sum_left - num, path, res);
            path.remove(path.size() - 1);
        }
    }
}
