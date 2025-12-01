class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq.values()) maxHeap.add(f);
        
        int removed = 0, count = 0;
        int n = arr.length;
        while (removed < n / 2) {
            removed += maxHeap.poll();
            count++;
        }
        return count;
    }
}
