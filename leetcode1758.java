class Solution {
    public int minOperations(String s) {
        int count1 = 0; 
        int count2 = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != (i % 2 == 0 ? '0' : '1')) {
                count1++;
            }

            if (c != (i % 2 == 0 ? '1' : '0')) {
                count2++;
            }
        }

        return Math.min(count1, count2);
    }
}
