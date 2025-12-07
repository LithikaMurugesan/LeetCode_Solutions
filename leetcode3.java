class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;

        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while (end < s.length()) {
            char c = s.charAt(end);

            while (set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }

            set.add(c);
            int size = end - start + 1;

            maxLength = Math.max(maxLength, size);

            end++;
        }

        return maxLength;
    }
}
