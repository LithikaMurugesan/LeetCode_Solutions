class Solution {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int mx = Math.max(a, Math.max(b, c));

        if (mx > sum - mx) {
            return sum - mx; 
        }

        return sum / 2; 
    }
}
