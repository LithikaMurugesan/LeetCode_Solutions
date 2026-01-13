class Solution {
    public double separateSquares(int[][] squares) {
        double low = 0, high = 0;
        double totalArea = 0;

        for (int[] s : squares) {
            high = Math.max(high, s[1] + s[2]);
            totalArea += (double) s[2] * s[2];
        }

        double half = totalArea / 2.0;

        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2.0;
            double below = 0;

            for (int[] s : squares) {
                double bottom = s[1];
                double top = s[1] + s[2];
                double side = s[2];

                if (mid <= bottom) continue;
                else if (mid >= top) below += side * side;
                else below += (mid - bottom) * side;
            }

            if (below < half) low = mid;
            else high = mid;
        }

        return low;
    }
}
