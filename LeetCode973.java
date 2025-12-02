class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int []>maxHeap = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        for(int[] p:points){
            int x = p[0];
            int y = p[1];
            int dist = x*x + y*y;
        
        maxHeap.offer(new int[]{dist,x,y});
        if(maxHeap.size()>k){
             maxHeap.poll();
        }
        }
        int result[][]  = new int [k][2];
        for (int i = 0; i < k; i++) {
            int[] top = maxHeap.poll();
            result[i][0] = top[1];
            result[i][1] = top[2];
        }
        return result ;
    }
}