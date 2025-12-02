class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int total = nums.length;

        long[] leftMin = new long[total];
        long[] rightMax = new long[total];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        for (int i = 0; i < total; i++) {
            sum += nums[i];
            maxHeap.offer(nums[i]);

            if (maxHeap.size() > n) {
                sum -= maxHeap.poll();
            }

            if (maxHeap.size() == n) {
                leftMin[i] = sum;
            } else {
                leftMin[i] = Long.MAX_VALUE; 
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        sum = 0;

        for (int i = total - 1; i >= 0; i--) {
            sum += nums[i];
            minHeap.offer(nums[i]);

            if (minHeap.size() > n) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == n) {
                rightMax[i] = sum;
            } else {
                rightMax[i] = Long.MIN_VALUE;
            }
        }
        long result = Long.MAX_VALUE;

        for (int i = n - 1; i < 2 * n; i++) {
            long diff = leftMin[i] - rightMax[i + 1];
            result = Math.min(result, diff);
        }

        return result;
    }
}
