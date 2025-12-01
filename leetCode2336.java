class SmallestInfiniteSet {
private int curr;
        private PriorityQueue<Integer> minHeap;
        private HashSet<Integer> added;
    public SmallestInfiniteSet() {
        curr = 1;
        minHeap = new PriorityQueue<>();
        added = new HashSet<>();
    }
    
    public int popSmallest() {
        if(!minHeap.isEmpty()&&minHeap.peek()<curr){
            int small = minHeap.poll();
            added.remove(small);
            return small;
        }
        return curr++;
    }
    
    public void addBack(int num) {
        if(num<curr && !added.contains(num)){
            minHeap.add(num);
            added.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */