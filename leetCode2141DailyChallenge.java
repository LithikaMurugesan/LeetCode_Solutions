class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long left = 0, right = 0;
        for (int b : batteries) {
            right += b;
        }

        right /= n; 

        while (left < right) {
            long mid = right - (right - left) / 2; 

            if (canRun(mid, n, batteries)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canRun(long time, int n, int[] batteries) {
        long total = 0;

        for (int b : batteries) {
            total += Math.min(b, time);
        }

        return total >= (long) n * time;
    }
}
