class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int p = nums.get(i);
            int best = -1;
            int bitmask = 1;

            while ((p & bitmask) != 0) {
                best = p - bitmask;
                bitmask <<= 1;
            }
            ans[i] = best;
        }
        return ans;
    }
}