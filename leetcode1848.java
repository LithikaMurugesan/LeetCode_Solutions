class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDist = Integer.MAX_VALUE;
        int sub = target - start;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int dist = Math.abs(i - start);
                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }
        return minDist;
    }
}
