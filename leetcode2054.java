import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int value1 = events[i][2];
            ans = Math.max(ans, value1); 
            int low = i + 1, high = n - 1, next = -1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (events[mid][0] >= events[i][1] + 1) {
                    next = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (next != -1) {
                ans = Math.max(ans, value1 + suffixMax[next]);
            }
        }

        return ans;
    }
}
