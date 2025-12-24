public class Solution {
    public static int minimumBoxes(int[] apple, int[] capacity) {

        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }
        Arrays.sort(capacity);
        int boxesUsed = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (totalApples <= 0) break;
            totalApples -= capacity[i];
            boxesUsed++;
        }

        return boxesUsed;
    }
}