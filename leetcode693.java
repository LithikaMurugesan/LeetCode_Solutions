class Solution {
    public boolean hasAlternatingBits(int n) {
        String num = Integer.toBinaryString(n);
        int var = num.length() - 1;
        for (int i = 0; i < var; i++) {
            if (num.charAt(i) == num.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
