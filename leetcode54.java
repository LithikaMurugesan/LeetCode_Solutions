class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> res = new ArrayList<>();

        int top = 0, bottom = mat.length - 1;
        int left = 0, right = mat[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int c = left; c <= right; c++)
                res.add(mat[top][c]);
            top++;

            for (int r = top; r <= bottom; r++)
                res.add(mat[r][right]);
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left; c--)
                    res.add(mat[bottom][c]);
                bottom--;
            }

            if (left <= right) {
                for (int r = bottom; r >= top; r--)
                    res.add(mat[r][left]);
                left++;
            }
        }

        return res;
    }
}
