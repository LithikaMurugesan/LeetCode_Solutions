class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] arr, int remain, int start,
                           List<Integer> path, List<List<Integer>> res) {

        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (remain < 0) return;

        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);
            backtrack(arr, remain - arr[i], i, path, res); 
            path.remove(path.size()-1);
        }
    }
}
