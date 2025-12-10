import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        int[] patternCode = encode(pattern);

        for (String word : words) {
            if (Arrays.equals(encode(word), patternCode)) {
                result.add(word);
            }
        }
        return result;
    }

    private int[] encode(String s) {
        int[] code = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        int id = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, id++);
            }
            code[i] = map.get(c);
        }
        return code;
    }
}
