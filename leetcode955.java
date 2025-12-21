class Solution {
    public int minDeletionSize(String[] strs) {

        int rows = strs.length;
        int cols = strs[0].length();
        int deleteCount = 0;

        boolean[] sorted = new boolean[rows - 1];

        for (int col = 0; col < cols; col++) {

            boolean needDelete = false;

            for (int row = 0; row < rows - 1; row++) {
                if (!sorted[row] &&
                    strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    needDelete = true;
                    break;
                }
            }

            if (needDelete) {
                deleteCount++;
                continue;
            }

            for (int row = 0; row < rows - 1; row++) {
                if (!sorted[row] &&
                    strs[row].charAt(col) < strs[row + 1].charAt(col)) {
                    sorted[row] = true;
                }
            }
        }

        return deleteCount;
    }
}
