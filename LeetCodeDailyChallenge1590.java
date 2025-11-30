class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int n : nums) total += n;

        int need = (int)(total % p);
        if (need == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long prefix = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int curr = (int)(prefix % p);

            int target = (curr - need + p) % p;

            if (map.containsKey(target)) {
                ans = Math.min(ans, i - map.get(target));
            }

            map.put(curr, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}
