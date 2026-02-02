class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(arr, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] arr, int remain, int start,
                           List<Integer> path, List<List<Integer>> res) {

        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i-1]) continue;

            if (arr[i] > remain) break;

            path.add(arr[i]);
            backtrack(arr, remain - arr[i], i + 1, path, res);
            path.remove(path.size()-1);
        }
    }
}
