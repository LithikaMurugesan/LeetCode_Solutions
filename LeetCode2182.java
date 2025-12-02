class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
                (a, b) -> b - a
        );

        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] > 0) {
                pq.offer(c);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {
            char biggest = pq.poll();  
            int idx = biggest - 'a';
            int available = count[idx];
            int use = Math.min(repeatLimit, available);
            for (int i = 0; i < use; i++) {
                ans.append(biggest);
            }

            count[idx] -= use;
            if (count[idx] == 0) continue;

            if (pq.isEmpty()) break;  

            char next = pq.poll(); 
            int nextIdx = next - 'a';


            ans.append(next);
            count[nextIdx]--;
            if (count[nextIdx] > 0) pq.offer(next);
            pq.offer(biggest);
        }

        return ans.toString();
    }
}
