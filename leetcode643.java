class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double avg = sum / k;

        for (int j = k; j < n; j++) {
            sum = sum - nums[j - k] + nums[j];
            avg = Math.max(avg, sum / k);
        }

        return avg;
    }
}