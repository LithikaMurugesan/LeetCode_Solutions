class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);
            int best = -1;
            for (int x = 0; x <= p; x++) {
                if ((x | (x + 1)) == p) {
                    best = x;
                    break;
                }
            }

            ans[i] = best;
        }

        return ans;
    }
}
