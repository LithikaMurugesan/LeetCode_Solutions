class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer> result = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones){
            result.add(s);
        }
            while(result.size()>1){
                int y = result.poll();
                int x = result.poll();
                if(y!=x)
                   result.add(y-x);
                
            }
        
        return result.isEmpty() ? 0: result.peek();
    }
}